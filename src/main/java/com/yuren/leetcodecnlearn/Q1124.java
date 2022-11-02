package com.yuren.leetcodecnlearn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-02 23:26
 */
public class Q1124 {
    public int longestWPI(int[] hours) {
        int maxInterval = 0;
        int n = hours.length;
        int[] sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int score = hours[i] > 8 ? 1 : -1;
            sums[i + 1] = sums[i] + score;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            int sum = sums[i];
            if (stack.isEmpty() || sums[stack.peek()] > sum) {
                stack.push(i);
            }
        }
        for (int j = n; j >= 0; j--) {
            int sum = sums[j];
            while (!stack.isEmpty() && sums[stack.peek()] < sum) {
                int interval = j - stack.pop();
                maxInterval = Math.max(maxInterval, interval);
            }
        }
        return maxInterval;
    }
}
