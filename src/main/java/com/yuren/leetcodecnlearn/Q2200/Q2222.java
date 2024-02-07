package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-07 22:00
 */
public class Q2222 {
    public long numberOfWays(String s) {
        long ans = 0, n0 = 0, n1 = 0, n10 = 0, n01 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                n01 += n0;
                n1++;
                ans += n10;
            } else {
                n10 += n1;
                n0++;
                ans += n01;
            }
        }
        return ans;
    }
}
