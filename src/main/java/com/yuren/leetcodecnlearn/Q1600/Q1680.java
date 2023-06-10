package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-11 02:31
 */
public class Q1680 {
    private static final int[] DP = new int[100001];

    private static final long MOD = 1000000007;

    public int concatenatedBinary(int n) {
        // 第一次之后都是打表
        if (DP[1] == 0) {
            int shift = 0;
            long result = 0;

            for (int i = 1; i < DP.length; ++i) {
                if ((i & (i - 1)) == 0) {
                    shift++;
                }
                result = ((result << shift) + i) % MOD;
                DP[i] = (int) (result);
            }
        }
        return DP[n];
    }
}
