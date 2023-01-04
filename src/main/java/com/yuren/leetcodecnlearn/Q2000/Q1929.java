package com.yuren.leetcodecnlearn.Q2000;

public class Q1929 {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n << 1];
        for (int i = 0; i < n; i++) {

            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }
}
