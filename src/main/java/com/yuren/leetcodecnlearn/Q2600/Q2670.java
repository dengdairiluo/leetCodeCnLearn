package com.yuren.leetcodecnlearn.Q2600;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-19 23:20
 */
public class Q2670 {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] suf = new int[n + 1];
        Set<Integer> s = new HashSet<>();
        for (int i = n - 1; i >= 0; --i) {
            s.add(nums[i]);
            suf[i] = s.size();
        }
        s.clear();
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            s.add(nums[i]);
            ans[i] = s.size() - suf[i + 1];
        }
        return ans;
    }
}
