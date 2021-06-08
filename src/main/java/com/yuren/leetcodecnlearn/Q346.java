package com.yuren.leetcodecnlearn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q346 {
    int size, windowSum = 0, count = 0;
    Deque<Integer> queue = new ArrayDeque<Integer>();

    public Q346(int size) {
        this.size = size;
    }

    public double next(int val) {
        ++count;
        // calculate the new sum by shifting the window
        queue.add(val);
        int tail = count > size ? (int) queue.poll() : 0;

        windowSum = windowSum - tail + val;

        return windowSum * 1.0 / Math.min(size, count);
    }
}
