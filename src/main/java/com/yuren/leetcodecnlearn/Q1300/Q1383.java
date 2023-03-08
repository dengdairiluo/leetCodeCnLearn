package com.yuren.leetcodecnlearn.Q1300;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-20 00:53
 */
public class Q1383 {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = ((long) efficiency[i] << 32) + speed[i];
        }
        Arrays.sort(arr);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long sum = 0;
        long max = 0;
        for (int i = n - 1; i >= 0; i--) {
            long l = arr[i];
            long a = l >> 32;
            int b = (int) l;
            if (queue.size() >= k) {
                sum -= queue.poll();
            }
            sum += b;
            max = Math.max(max, sum * a);
            queue.add(b);
        }
        return (int) (max % 1000000007);
    }
}
