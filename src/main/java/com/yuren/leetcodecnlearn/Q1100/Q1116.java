package com.yuren.leetcodecnlearn.Q1100;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-30 22:57
 */
public class Q1116 {
    private final Lock l = new ReentrantLock();
    private final Condition z = l.newCondition();
    private final Condition o = l.newCondition();
    private final Condition e = l.newCondition();
    private int n;
    private volatile int curValue = 0;

    public Q1116(int n) {
        this.n = n;
    }

    /**
     * printNumber.accept(x) outputs "x", where x is an integer.
     *
     * @param printNumber
     * @throws InterruptedException
     */
    public void zero(IntConsumer printNumber) throws InterruptedException {
        l.lock();
        try {
            for (int i = 1; i <= n; i++) {

                if (curValue != 0) {
                    z.await();
                }
                printNumber.accept(0);

                if (i % 2 == 1) {
                    curValue = 1;
                    o.signal();
                } else {
                    curValue = 2;
                    e.signal();
                }
            }
        } finally {
            l.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {

        l.lock();
        try {
            for (int i = 2; i <= n; i += 2) {
                if (curValue != 2) {
                    e.await();
                }
                printNumber.accept(i);
                curValue = 0;
                z.signal();
            }
        } finally {
            l.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        l.lock();
        try {
            for (int i = 1; i <= n; i += 2) {

                if (curValue != 1) {
                    o.await();
                }

                printNumber.accept(i);
                curValue = 0;
                z.signal();
            }
        } finally {
            l.unlock();
        }
    }

}
