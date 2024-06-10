package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-10 下午11:06
 */
public class Q2466 {
    private static final int MOD = 1_000_000_007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int ans = 0;
        int[] f = new int[high + 1]; // f[i] 表示构造长为 i 的字符串的方案数
        f[0] = 1; // 构造空串的方案数为 1
        for (int i = 1; i <= high; i++) {
            if (i >= one) f[i] = (f[i] + f[i - one]) % MOD;
            if (i >= zero) f[i] = (f[i] + f[i - zero]) % MOD;
            if (i >= low) ans = (ans + f[i]) % MOD;
        }
        return ans;
    }
}
