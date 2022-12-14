package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-14 23:37
 */
public class Q1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int len = 1;
        int nMin = Integer.MAX_VALUE;
        int nMax = Integer.MIN_VALUE;
        for (int j : arr) {
            if (nMax < j) {
                nMax = j;
            }
            if (nMin > j) {
                nMin = j;
            }
        }
        int[] dp = new int[nMax - nMin + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] - nMin;
        }
        for (int j : arr) {
            if (j - difference >= 0 && j - difference <= nMax - nMin) {
                dp[j] = dp[j - difference] + 1;
            } else {
                dp[j] = 1;
            }
            len = Math.max(len, dp[j]);
        }
        return len;
    }
}
