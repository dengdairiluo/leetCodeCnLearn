package com.yuren.leetcodecnlearn.Q2200;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-27 23:19
 */
public class Q2263 {
    public int convertArray(int[] nums) {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);
        int ans = getAns(nums, copy);
        reverse(copy);
        ans = Math.min(ans, getAns(nums, copy));
        return ans;
    }

    private int getAns(int[] nums, int[] copy) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int num : nums) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                min = Math.min(min, dp[j]);
                dp[j] = min + Math.abs(num - copy[j]);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int v : dp) {
            ans = Math.min(v, ans);
        }
        return ans;
    }

    private void reverse(int[] arr) {
        int n = arr.length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
