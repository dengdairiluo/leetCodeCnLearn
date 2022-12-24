package com.yuren.leetcodecnlearn.Q1200;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-04 00:33
 */
public class Q1188 {

    BlockingQueue<Integer> queue;

    public Q1188(int capacity) {
        queue = new ArrayBlockingQueue<>(capacity, true);

    }

    public void enqueue(int element) throws InterruptedException {
        queue.put(element);

    }

    public int dequeue() throws InterruptedException {
        return queue.take();

    }

    public int size() {
        return queue.size();

    }
}
