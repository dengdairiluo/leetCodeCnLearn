package com.yuren.leetcodecnlearn.Q500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-02-25 23:44
 */
public class Q541 {
    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        int n = s.length();
        for (int l = 0; l < n; l = l + 2 * k) {
            int r = l + k - 1;
            reverse(cs, l, Math.min(r, n - 1));
        }
        return String.valueOf(cs);
    }

    void reverse(char[] cs, int l, int r) {
        while (l < r) {
            char c = cs[l];
            cs[l] = cs[r];
            cs[r] = c;
            l++;
            r--;
        }
    }
}
