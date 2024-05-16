package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-16 下午11:52
 */
public class Q2417 {
    public int closestFair(int n) {
        int len = String.valueOf(n).length();
        int one = (len + 2 - len % 2) / 2;
        String ones = "111111";
        String zeros = "000000";
        long ans = (Long.parseLong("1" + zeros.substring(0, one) + ones.substring(0, one - 1)));
        if (len % 2 == 1) {
            return (int) ans;

        }
        for (int i = n; i < n + Math.pow(10, one + 1); i++) {
            int c = 0;
            int j = i;
            while (j > 0) {
                int v = j % 10;
                c += v % 2 == 0 ? 1 : -1;
                j = j / 10;
            }
            if (c == 0) return i;
        }
        return (int) ans;
    }
}
