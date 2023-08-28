package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-28 23:26
 */
public class Q1888 {
    public int minFlips(String s) {
        int n = s.length();
        char[] t = {'0', '1'};
        char[] c = s.toCharArray();
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur += c[i] ^ t[i & 1];
        }
        int res = Math.min(cur, n - cur);
        if ((n & 1) == 0) {
            return res;
        }
        for (int i = 0; i < n; i++) {
            cur -= c[i] ^ t[i & 1];
            cur += c[i] ^ t[(i + n) & 1];
            res = Math.min(res, Math.min(cur, n - cur));
        }
        return res;
    }
}
