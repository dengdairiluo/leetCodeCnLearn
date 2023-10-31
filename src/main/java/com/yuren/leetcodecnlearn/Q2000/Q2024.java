package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-31 23:44
 */
public class Q2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int max = 0;
        int left = 0;
        int[] h = new int[97];
        int res = 0;
        char[]  arr = answerKey.toCharArray();
        for (int right = 0; right < arr.length; right++) {
            h[arr[right]]++;
            max = Math.max(max, h[arr[right]]);
            while (right - left + 1 > max + k) {
                h[arr[left++]]--;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
