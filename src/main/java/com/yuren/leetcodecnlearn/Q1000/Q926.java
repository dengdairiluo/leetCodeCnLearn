package com.yuren.leetcodecnlearn.Q1000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-12 01:18
 */
public class Q926 {
    public int minFlipsMonoIncr(String s) {
        int n = s.length(), one = 0, ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, one * 2 - i);
            if (s.charAt(i) == '1') {
                one++;
            }
        }
        return Math.min(one, ans + n - one);
    }
}
