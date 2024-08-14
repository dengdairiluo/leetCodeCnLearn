package com.yuren.leetcodecnlearn.Q2500;

import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-15 01:16
 */
public class Q2599 {
    public int makePrefSumNonNegative(int[] nums) {
        long sum = 0;
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (num < 0) pq.offer(num);
            if (sum + num < 0) {
                sum -= pq.poll();
                ++ans;
            }
            sum += num;
        }
        return ans;
    }
}
