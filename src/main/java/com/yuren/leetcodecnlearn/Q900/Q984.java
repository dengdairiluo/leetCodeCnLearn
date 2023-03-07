package com.yuren.leetcodecnlearn.Q900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-07 23:52
 */
public class Q984 {
    public String strWithout3a3b(int a, int b) {
        StringBuilder res = new StringBuilder();
        while (a > 0 && b > 0) {
            if (a > b) {
                res.append("aab");
                a -= 2;
                b--;
            } else if (a == b) {
                res.append("ab");
                a--;
                b--;
            } else if (a < b) {
                res.append("bba");
                a--;
                b -= 2;
            }
        }
        while (a > 0) {
            res.append('a');
            a--;
        }
        while (b > 0) {
            res.append('b');
            b--;
        }
        return res.toString();
    }
}
