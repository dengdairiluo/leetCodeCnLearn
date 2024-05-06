package com.yuren.leetcodecnlearn.Q2300;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-06 下午11:38
 */
public class Q2398 {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int ans = 0;
        Deque<Integer> q = new ArrayDeque<Integer>();
        long sum = 0L;
        // 枚举区间右端点 right，计算区间左端点 left 的最小值
        for (int left = 0, right = 0; right < chargeTimes.length; ++right) {
            // 及时清除队列中的无用数据，保证队列的单调性
            while (!q.isEmpty() && chargeTimes[right] >= chargeTimes[q.peekLast()])
                q.pollLast();
            q.addLast(right);
            sum += runningCosts[right];
            // 如果左端点 left 不满足要求，就不断右移 left
            while (!q.isEmpty() && chargeTimes[q.peekFirst()] + (right - left + 1) * sum > budget) {
                // 及时清除队列中的无用数据，保证队列的单调性
                if (q.peekFirst() == left) q.pollFirst();
                sum -= runningCosts[left++];
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
