package com.yuren.leetcodecnlearn.Q2500;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-08 下午11:10
 */
public class Q2524 {
    private static final long MOD = (long) 1e9 + 7;

    public int maxFrequencyScore(int[] nums, int k) {
        int ans = 0;
        long score = 0;
        Map<Integer, Deque<Integer>> stMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int x = nums[i];
            if (!stMap.containsKey(x)) {
                score += x;
                Deque<Integer> st = new ArrayDeque<>();
                st.push(x);
                stMap.put(x, st);
            } else {
                Deque<Integer> st = stMap.get(x);
                long last = st.peek(), cur = last * x % MOD;
                score += cur - last;
                st.push((int) cur);
            }
            if (i >= k - 1) {
                ans = Math.max(ans, (int) ((score % MOD + MOD) % MOD));
                x = nums[i - k + 1];
                Deque<Integer> st = stMap.get(x);
                score -= st.pop();
                if (st.isEmpty()) stMap.remove(x);
                else score += st.peek();
            }
        }
        return ans;
    }
}
