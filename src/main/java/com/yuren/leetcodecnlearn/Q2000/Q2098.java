package com.yuren.leetcodecnlearn.Q2000;

import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-07 23:21
 */
public class Q2098 {
    public long largestEvenSum(int[] nums, int k) {
        PriorityQueue<Integer> evenQueue = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> oddQueue = new PriorityQueue<>((a, b) -> b - a);

        for (int n : nums) {
            if (n % 2 == 0) {
                evenQueue.add(n);
            } else {
                oddQueue.add(n);
            }
        }
        long res = 0;
        if (k % 2 == 1) {
            if (evenQueue.isEmpty()) {
                return -1;
            }
            k -= 1;
            res += evenQueue.poll();
        }
        int candidate1 = -1, candidate2 = -1;
        while (k > 0) {
            // left more than 1, can retrieve two at same time
            if (candidate1 == -1 && oddQueue.size() >= 2) {
                candidate1 = oddQueue.poll() + oddQueue.poll();
            }
            if (candidate2 == -1 && evenQueue.size() >= 2) {
                candidate2 = evenQueue.poll() + evenQueue.poll();
            }
            if (candidate1 == -1 && candidate2 == -1) {
                return -1;
            }
            if (candidate1 < candidate2) {
                res += candidate2;
                candidate2 = -1;
            } else {
                res += candidate1;
                candidate1 = -1;
            }
            k -= 2;
        }

        return res;
    }
}
