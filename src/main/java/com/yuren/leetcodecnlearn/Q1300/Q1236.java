package com.yuren.leetcodecnlearn.Q1300;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-26 06:03
 */
public class Q1236 {
    /**
     * // This is the HtmlParser's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface HtmlParser {
     * public List<String> getUrls(String url) {}
     * }
     */

    Set<String> visited = new HashSet<>();

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        List<String> ans = new ArrayList<>();
        String hostname = getHostName(startUrl);
        crawlHelper(ans, startUrl, htmlParser, hostname);
        return ans;
    }

    private void crawlHelper(List<String> ans, String url, HtmlParser htmlParser, String hostname) {
        if (visited.contains(url)) return;
        if (isValidSameHost(hostname, url)) {
            ans.add(url);
            visited.add(url);
        } else {
            return;
        }
        for (String nextUrl : htmlParser.getUrls(url)) {
            crawlHelper(ans, nextUrl, htmlParser, hostname);
        }
    }

    private boolean isValidSameHost(String hostname, String http) {
        return hostname.equals(getHostName(http));
    }

    private String getHostName(String url) {
        int start = 8;
        int end = start;
        while (end < url.length() && url.charAt(end) != '/') {
            end++;
        }
        return url.substring(start, end);
    }

    private static class HtmlParser {
        public List<String> getUrls(String url) {
            return null;
        }
    }
}
