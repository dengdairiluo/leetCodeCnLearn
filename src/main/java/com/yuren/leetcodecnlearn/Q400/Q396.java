package com.yuren.leetcodecnlearn.Q400;

public class Q396 {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int f = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += nums[i] * i;
        }
        int ans = f;
        for (int i = 1; i < n; i++) {
            f = f + sum - n * nums[n - i];
            ans = Math.max(f, ans);
        }
        return ans;
    }
}
