package com.yuren.leetcodecnlearn.Q1300;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-27 23:29
 */
public class Q1242 {
    public final int THREAD_NUM = 30;
    private Map<String, String> accessedUrl = new ConcurrentHashMap<>();
    public volatile int threadsNum;
    private volatile List<String> toAccessUrlList = new LinkedList<>();
    private List<String> res = new ArrayList<>();
    private String startUrlHostName = "";
    private Lock taskLock = new ReentrantLock();
    private Condition notEmptyCondition = taskLock.newCondition();
    private Semaphore taskConcurrency = null;
    private HtmlParser htmlParser;

    public boolean duplicatedUrl(String url) {
        boolean duplicated = this.accessedUrl.containsKey(url);
        this.accessedUrl.put(url, "");
        return duplicated;
    }

    public List<String> getRes() {
        return this.res;
    }

    public HtmlParser getHtmlParser() {
        return this.htmlParser;
    }

    public void getTaskToken() {
        try {
            this.taskConcurrency.acquire();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void releaseTaskToken() {
        try {
            this.taskConcurrency.release();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Condition getNotEmptyCondition() {
        return this.notEmptyCondition;
    }

    public Lock getTaskLock() {
        return this.taskLock;
    }

    public boolean hasNextUrl() {
        return !toAccessUrlList.isEmpty();
    }

    public List<String> getToAccessUrlList() {
        return this.toAccessUrlList;
    }

    public String getNextUrl() {
        return this.toAccessUrlList.remove(0);
    }

    public void addUrl(List<String> urls) {
        this.toAccessUrlList.addAll(urls);
    }

    public void addUrl(String url) {
        this.toAccessUrlList.add(url);
    }

    public int getAvailablePermites() {
        return this.taskConcurrency.availablePermits();
    }

    public boolean completeCrawl() {
        return this.toAccessUrlList.isEmpty() && this.taskConcurrency.availablePermits() == this.threadsNum;
    }

    public boolean sameHostNameAsStartUrl(String url) {
        return this.startUrlHostName.equals(parseHostname(url));
    }

    public Q1242(int threadsNum, HtmlParser htmlParser, String startUrl) {
        this.threadsNum = threadsNum;
        this.taskConcurrency = new Semaphore(threadsNum);
        this.htmlParser = htmlParser;
        this.startUrlHostName = parseHostname(startUrl);
        this.addUrl(startUrl);

    }

    public Q1242() {
    }


    private String parseHostname(String url) {
        int indexOfPathStart = url.indexOf('/', 7);
        indexOfPathStart = indexOfPathStart < 0 ? url.length() : indexOfPathStart;
        return url.substring(7, indexOfPathStart);
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        long start = System.currentTimeMillis();
        Q1242 Q1242 = new Q1242(THREAD_NUM, htmlParser, startUrl);

        Thread thread1 = new Thread(new Producer(Q1242));
        Thread thread2 = new Thread(new Producer(Q1242));
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (Exception e) {

        }
        return Q1242.res;
    }

    public void startTask(Q1242 Q1242, String url) {
        new Thread(new CrawlTask(Q1242, url)).start();
    }


}

class Producer implements Runnable {
    private Q1242 Q1242;

    public Producer(Q1242 Q1242) {
        this.Q1242 = Q1242;
    }

    public void run() {
        String url = null;
        while (true) {
            Q1242.getTaskLock().lock();
            try {
                if (Q1242.completeCrawl()) {
                    break;
                }
                while (!Q1242.hasNextUrl()) {
                    try {
                        System.out.println(String.format("当前任务数为%d，正在爬虫的数目为%d，总线程数为%d, 主线程等待", Q1242.getToAccessUrlList().size(), Q1242.threadsNum - Q1242.getAvailablePermites(), Q1242.threadsNum));
                        Q1242.getNotEmptyCondition().await();
                        System.out.println(String.format("主线程被唤醒，当前任务数为%d，正在爬虫的数目为%d，总线程数为%d, 可用token为%d", Q1242.getToAccessUrlList().size(), Q1242.threadsNum - Q1242.getAvailablePermites(), Q1242.threadsNum, Q1242.getAvailablePermites()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (Q1242.completeCrawl()) {

                        return;
                    }

                }

                url = Q1242.getNextUrl();
                if (Q1242.duplicatedUrl(url)) {
                    continue;
                }
                Q1242.getRes().add(url);
            } finally {
                Q1242.getTaskLock().unlock();
            }
            System.out.println("主线程准备获取token");
            Q1242.getTaskToken();
            System.out.println("主线程获取到token");
            System.out.println("主线程发布任务" + url);
            Q1242.startTask(Q1242, url);
        }
    }


}

class CrawlTask implements Runnable {
    private Q1242 q1242;
    private String taskUrl = null;

    public CrawlTask(Q1242 Q1242, String url) {
        this.q1242 = Q1242;
        this.taskUrl = url;
    }

    @Override
    public void run() {
        System.out.println(String.format("  线程%s开始获取%s", Thread.currentThread().getId(), this.taskUrl));
        List<String> parsedUrls = this.q1242.getHtmlParser().getUrls(taskUrl);
        System.out.println(String.format("  线程%s解析的结果%s", Thread.currentThread().getId(), parsedUrls));
        Iterator<String> urlsIter = parsedUrls.iterator();
        while (urlsIter.hasNext()) {
            if (!this.q1242.sameHostNameAsStartUrl(urlsIter.next())) {
                urlsIter.remove();
            }
        }
        System.out.println(String.format("  线程%s解析过滤后剩余%s", Thread.currentThread().getId(), parsedUrls));
        this.q1242.getTaskLock().lock();
        try {
            System.out.println(String.format("  线程%s开始往任务集增加url", Thread.currentThread().getId()));
            this.q1242.addUrl(parsedUrls);
        } finally {
            System.out.println(String.format("  线程%s开始释放token", Thread.currentThread().getId()));
            this.q1242.releaseTaskToken();
            System.out.println(String.format("  线程%s开始signal", Thread.currentThread().getId()));
            this.q1242.getNotEmptyCondition().signalAll();
            System.out.println(String.format("  线程%s开始释放lock", Thread.currentThread().getId()));
            this.q1242.getTaskLock().unlock();
            System.out.println(String.format("  线程%s结束", Thread.currentThread().getId()));
        }

    }
}

class HtmlParser {
    public List<String> getUrls(String url) {
        return new ArrayList<>();
    }
}