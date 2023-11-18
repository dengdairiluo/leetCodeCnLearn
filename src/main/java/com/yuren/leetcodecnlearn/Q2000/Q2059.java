package com.yuren.leetcodecnlearn.Q2000;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-18 23:44
 */
public class Q2059 {
    public int minimumOperations(int[] nums, int start, int goal) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(start);
        boolean[] used = new boolean[1001];
        if (start == goal) {
            return 0;
        }
        int len = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            len++;
            for (; size > 0; size--) {
                int num = deque.poll();

                if (num > 1000 || num < 0) {
                    continue;
                }
                for (int i = 0; i < nums.length; i++) {
                    int t = nums[i] + num;
                    if (t == goal) {
                        return len;
                    }
                    if (t <= 1000 && t >= 0 && !used[t]) {
                        used[t] = true;
                        deque.offer(t);
                    }
                    t = num - nums[i];
                    if (t == goal) {
                        return len;
                    }
                    if (t <= 1000 && t >= 0 && !used[t]) {
                        used[t] = true;
                        deque.offer(t);
                    }
                    t = num ^ nums[i];
                    if (t == goal) {
                        return len;
                    }
                    if (t <= 1000 && t >= 0 && !used[t]) {
                        used[t] = true;
                        deque.offer(t);
                    }
                }
            }
        }
        return -1;
    }
}
