package com.yuren.leetcodecnlearn;

import java.util.LinkedList;
import java.util.Queue;

public class Q933 {
    Queue<Integer> q;

    public Q933() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        q.add(t);
        while (q.peek() < t - 3000)
            q.poll();
        return q.size();
    }
}
