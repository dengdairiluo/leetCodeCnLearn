package com.yuren.leetcodecnlearn.Q2700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-11-16 23:27
 */
public class Q2787 {
    int numberOfWays(int n, int x) {
        long[] f = new long[n + 1];
        f[0] = 1;
        // 本题数据范围小，Math.pow 的计算结果一定准确
        for (int i = 1; Math.pow(i, x) <= n; i++) {
            int v = (int) Math.pow(i, x);
            for (int s = n; s >= v; s--) {
                f[s] += f[s - v];
            }
        }
        return (int) (f[n] % 1_000_000_007);
    }
}
