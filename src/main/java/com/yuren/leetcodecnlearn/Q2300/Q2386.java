package com.yuren.leetcodecnlearn.Q2300;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-30 下午11:04
 */
public class Q2386 {
    public long kSum(int[] nums, int k) {
        int n = nums.length;
        long sum = 0, abs = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                sum += nums[i];
            } else {
                nums[i] = -nums[i];
            }
            abs += nums[i];
        }
        Arrays.sort(nums);

        long lo = 0, hi = abs;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (check(nums, mid, k)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return sum - hi;
    }

    private int count = 0;

    private boolean check(int[] nums, long sum, int k) {
        count = k;
        dfs(nums, 0, sum);
        return count <= 0;
    }

    private void dfs(int[] nums, int i, long target) {
        if (--count <= 0) return;
        for (int j = i; j < nums.length; j++) {
            if (nums[j] > target) return;
            dfs(nums, j + 1, target - nums[j]);
            if (count <= 0) return; // 剪枝：一旦满足条件立即返回
        }
    }
}
