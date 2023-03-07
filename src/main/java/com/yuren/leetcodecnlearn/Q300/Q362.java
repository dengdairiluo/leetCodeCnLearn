package com.yuren.leetcodecnlearn.Q300;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-12-10 23:58
 */
public class Q362 {
    /**
     * Initialize your data structure here.
     */
    Queue<Integer> q;
    int count;

    public Q362() {
        q = new LinkedList<>();
        count = 0;
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        q.add(timestamp);
        count++;
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        if (q.size() == 0) return 0;
        int peek = q.peek();
        while (peek < timestamp - 299) {
            q.poll();
            count--;
            if (q.isEmpty()) return 0;
            peek = q.peek();
        }
        return count;
    }
}
