package com.yuren.leetcodecnlearn.Q1200;

import java.util.concurrent.Semaphore;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-18 22:41
 */
public class Q1226 {
    // 叉子
    private static final Semaphore[] forks = {new Semaphore(1), new Semaphore(1),
            new Semaphore(1), new Semaphore(1), new Semaphore(1)};

    // 惩罚锁
    final Semaphore lock = new Semaphore(1);


    public Q1226() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        while (true) {
            if (forks[philosopher % 5].tryAcquire(1)) {
                if (forks[(philosopher + 1) % 5].tryAcquire(1)) {
                    pickLeftFork.run();
                    pickRightFork.run();
                    eat.run();
                    putLeftFork.run();
                    putRightFork.run();
                    forks[philosopher % 5].release(1);
                    forks[(philosopher + 1) % 5].release(1);
                    // 当一个人吃完 后唤醒一个被惩罚的人
                    lock.release(1);
                    break;
                } else {
                    forks[philosopher % 5].release(1);
                }
            }
            // 只要有一个叉子抢不过的需要接受惩罚 堵塞
            lock.acquire(1);
        }
    }
}
