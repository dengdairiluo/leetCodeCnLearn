package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-27 22:53
 */
public class Q1415 {
    public String getHappyString(int n, int k) {
        // f(n, a) = f(n-1, b) + f(n-1, c)
        // f(n, b) = f(n-1, a) + f(n-1, c)
        // f(n, c) = f(n-1, a) + f(n-1, b)
        // 1<<(i-1)
        if (k > (1 << (n - 1)) * 3) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = n, prev = -1; i >= 1; --i) {
            for (int j = 0; j < 3; ++j) {
                if (j == prev) continue;
                if (j == 2 || (1 << (i - 1)) >= k) {
                    prev = j;
                    break;
                }
                k -= 1 << (i - 1);
            }
            sb.append((char) ('a' + prev));
        }
        return sb.toString();
    }
}
