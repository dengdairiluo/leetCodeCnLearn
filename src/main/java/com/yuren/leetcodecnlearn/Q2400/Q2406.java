package com.yuren.leetcodecnlearn.Q2400;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-11 下午11:27
 */
public class Q2406 {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Queue<Integer> pq = new PriorityQueue<>();
        for (int[] p : intervals) {
            if (!pq.isEmpty() && pq.peek() < p[0]) pq.poll();
            pq.offer(p[1]);
        }
        return pq.size();
    }
}
