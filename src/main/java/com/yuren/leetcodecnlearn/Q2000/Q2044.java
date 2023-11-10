package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-10 23:51
 */
public class Q2044 {
    int ans = 0;

    public int countMaxOrSubsets(int[] nums) {
        int target = 0;
        for (int n : nums) {
            target |= n;
        }
        dfs(nums, 0, 0, target);
        return ans;
    }

    public void dfs(int[] nums, int idx, int cur, int target) {
        int n = nums.length;
        if (cur == target) {
            ans += 1 << (n - idx);
            return;
        }
        if (idx >= n) {
            return;
        }
        dfs(nums, idx + 1, cur, target);
        dfs(nums, idx + 1, cur | nums[idx], target);
    }
}
