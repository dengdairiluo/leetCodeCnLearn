package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-18 00:14
 */
public class Q1005 {
    public int countQuadruplets(int[] nums) {
        int n = nums.length, ans = 0;
        int[] cnt = new int[10010];
        for (int b = n - 3; b >= 1; b--) {
            for (int d = b + 2; d < n; d++) cnt[nums[d] - nums[b + 1] + 200]++;
            for (int a = 0; a < b; a++) ans += cnt[nums[a] + nums[b] + 200];
        }
        return ans;
    }
}
