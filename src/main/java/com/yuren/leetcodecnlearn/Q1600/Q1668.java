package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-08 00:23
 */
public class Q1668 {
    public int maxRepeating(String sequence, String word) {
        char[] arr1 = sequence.toCharArray();
        char[] arr2 = word.toCharArray();
        int[] next = new int[arr2.length];
        getNext(arr2, next);
        return kmp(arr1, arr2, next);
    }

    private void getNext(char[] arr, int[] next) {
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            while (j != 0 && arr[i] != arr[j]) {
                j = next[j - 1];
            }
            if (arr[i] == arr[j]) {
                j++;
            }
            next[i] = j;
        }
    }

    private int kmp(char[] arr1, char[] arr2, int[] next) {
        int[] dp = new int[arr1.length + 1];
        int j = 0;
        int cnt = 0;
        for (int i = 0; i < arr1.length; i++) {
            while (j != 0 && arr1[i] != arr2[j]) {
                j = next[j - 1];
            }
            if (arr1[i] == arr2[j]) {
                j++;
            }
            if (j == arr2.length) {

                dp[i + 1] = dp[i - j + 1] + 1;
                cnt = Math.max(dp[i + 1], cnt);
                j = next[j - 1];
            }
        }
        // for(int i = 1; i < dp.length; i++) {
        //     System.out.print(dp[i] +  " ");
        // }
        // System.out.println();
        return cnt;
    }
}
