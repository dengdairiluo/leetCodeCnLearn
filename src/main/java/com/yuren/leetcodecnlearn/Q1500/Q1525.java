package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-13 23:47
 */
public class Q1525 {
    public int numSplits(String s) {
        int res = 0;
        int[] arr = new int[26];
        int[] arr1 = new int[26];
        int differentCount = 0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (arr[aChar - 'a'] == 0) {
                differentCount++;
            }
            arr[aChar - 'a']++;
        }
        int left = 0;
        for (char aChar : chars) {
            arr[aChar - 'a']--;
            if (arr1[aChar - 'a'] == 0) {
                left++;
            }
            arr1[aChar - 'a']++;

            if (arr[aChar - 'a'] == 0) {
                differentCount--;
            }
            if (left == differentCount) {
                res++;
            }
        }
        return res;
    }
}
