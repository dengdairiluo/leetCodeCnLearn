package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-29 下午11:15
 */
public class Q2444 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int minI = -1, maxI = -1, i0 = -1;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x == minK) minI = i;
            if (x == maxK) maxI = i;
            // 子数组不能包含 nums[i0]
            if (x < minK || x > maxK) i0 = i;
            ans += Math.max(Math.min(minI, maxI) - i0, 0);
        }
        return ans;
    }
}
