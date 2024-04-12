package com.yuren.leetcodecnlearn.Q1100;

import java.util.concurrent.Semaphore;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-30 22:56
 */
public class Q1115 {
    Semaphore foo = new Semaphore(1);
    Semaphore bar = new Semaphore(0);
    private int n;
    public Q1115(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.acquire();
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire();
            printBar.run();
            foo.release();
        }
    }
}
