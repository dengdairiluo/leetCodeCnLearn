package com.yuren.leetcodecnlearn.Q2500;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-10 23:38
 */
public class Q2588 {
    public long beautifulSubarrays(int[] nums) {
        long ans = 0;
        int s = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(s, 1); // s[0]
        for (int x : nums) {
            s ^= x;
            ans += cnt.getOrDefault(s, 0);
            cnt.merge(s, 1, Integer::sum);
        }
        return ans;
    }
}
