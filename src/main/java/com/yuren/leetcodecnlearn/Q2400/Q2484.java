package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-18 下午11:41
 */
public class Q2484 {
    private static final long MOD = (long) 1e9 + 7;

    public int countPalindromes(String S) {
        char[] s = S.toCharArray();
        int[] pre = new int[10], suf = new int[10];
        int[][] pre2 = new int[10][10], suf2 = new int[10][10];
        for (int i = s.length - 1; i >= 0; --i) {
            int d = s[i] - '0';
            for (int j = 0; j < 10; ++j)
                suf2[d][j] += suf[j];
            ++suf[d];
        }

        long ans = 0L;
        for (char d : s) {
            d -= '0';
            --suf[d];
            for (int j = 0; j < 10; ++j)
                suf2[d][j] -= suf[j]; // 撤销
            for (int j = 0; j < 10; ++j)
                for (int k = 0; k < 10; ++k)
                    ans += (long) pre2[j][k] * suf2[j][k]; // 枚举所有字符组合
            for (int j = 0; j < 10; ++j)
                pre2[d][j] += pre[j];
            ++pre[d];
        }
        return (int) (ans % MOD);
    }
}
