package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-16 23:07
 */
public class Q2116 {
    public boolean canBeValid(String s, String locked) {
        int n = s.length(), mx = 0, mn = 0;
        if ((n & 1) == 1) return false;
        for (int i = 0; i < n; ++i) {
            if (locked.charAt(i) == '0') {
                mx++;
                if (mn > 0) mn--;
            } else if (s.charAt(i) == '(') {
                mx++;
                mn++;
            } else {
                mx--;
                if (mn > 0) mn--;
            }
            if (mx < mn) return false;
        }
        return mn == 0;
    }
}
