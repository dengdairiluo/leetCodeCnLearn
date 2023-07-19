package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-19 22:29
 */
public class Q1781 {
    public int beautySum(String s) {
        int n = s.length(), res = 0;
        for (int i = 0; i < n; i++) {
            int[] f = new int[26];
            int[] freq = new int[n + 1];
            int max = 0, min = 0;
            for (int j = i; j < n; j++) {
                int index = s.charAt(j) - 'a';
                freq[f[index]]--;
                f[index]++;
                freq[f[index]]++;
                max = Math.max(max, f[index]);
                if (f[index] == 1) {
                    min = 1;
                } else if (freq[min] == 0) {
                    min++;
                }
                res += max - min;
            }
        }
        return res;
    }
}
