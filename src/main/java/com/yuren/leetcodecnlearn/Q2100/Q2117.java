package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-16 23:09
 */
public class Q2117 {
    public String abbreviateProduct(int left, int right) {
        long a = 1L;
        int icz = 0;
        String res;
        double sign = 1.0;
        int ict = 0;
        for (int i = left; i <= right; i++) {
            a = a * i;
            sign = sign * i;
            while (sign > 10) {
                sign = sign / 10;
                ict++;
            }
            while (a % 10 == 0) {
                a = a / 10;
                icz++;
            }
            if (a > 1000000000000L) {
                a = a % 1000000000000L;
            }
        }
        String sa = a + "";
        String ss = sign + "";
        ss = ss.replace(".", "");
        if (ict - icz < 9) {
            res = sa + "e" + icz;
        } else if (ict - icz == 9) {
            if (sa.length() < 5) {
                sa = "00000" + sa;
            }
            res = ss.substring(0, 5) + sa.substring(sa.length() - 5, sa.length()) + "e" + icz;
        } else {
            if (sa.length() < 5) {
                sa = "00000" + sa;
            }
            res = ss.substring(0, 5) + "..." + sa.substring(sa.length() - 5, sa.length()) + "e" + icz;
        }
        return res;

    }
}
