package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-25 下午11:51
 */
public class Q2437 {
    public int countTime(String time) {
        int ans = 1;
        char a = time.charAt(0), b = time.charAt(1), c = time.charAt(3), d = time.charAt(4);
        if (d == '?') ans *= 10;
        if (c == '?') ans *= 6;
        if (a == '?' && b == '?') {
            ans *= 24;
        } else if (b == '?') {
            if (a == '2') ans *= 4;
            else ans *= 10;
        } else if (a == '?') {
            if (b <= '9' && b >= '4') ans *= 2;
            else ans *= 3;
        }
        return ans;
    }
}
