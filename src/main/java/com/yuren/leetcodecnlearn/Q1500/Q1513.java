package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-06 23:39
 */
public class Q1513 {
    public int numSub(String s) {
        int n = s.length();
        int cnt = 0;
        long res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (chars[i] == '1') {
                cnt++;
                res += cnt;
            } else {
                cnt = 0;
            }
        }
        double r = res % (1e9 + 7);
        return (int) r;
    }
}
