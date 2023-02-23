package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-23 23:50
 */
public class Q1404 {
    public int numSteps(String s) {
        int ans = 0, carry = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int r = s.charAt(i) - '0';
            if (r == 0) {
                if (carry == 1) {
                    ans += 2;
                } else {
                    ans++;
                }
            } else {
                if (carry == 1) {
                    ans++;
                } else {
                    if (i != 0) {
                        ans += 2;
                    }
                    carry = 1;
                }
            }
        }
        return ans;
    }
}
