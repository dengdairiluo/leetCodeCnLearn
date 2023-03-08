package com.yuren.leetcodecnlearn.Q1300;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-21 23:40
 */
public class Q1397 {
    private static int MOD = (int) 1e9 + 7;
    /**
     * n1表示s1的char数组，n2表示s2的char数组，e表示evil的char数组
     */
    private char[] n1, n2, e;
    private int[] next;
    private int[][] dp;
    private int n;

    public int findGoodStrings(int n, String s1, String s2, String evil) {
        n1 = new char[n];
        n2 = new char[n];
        e = evil.toCharArray();
        this.n = n;
        dp = new int[n][e.length];
        // 长于n部分的抛弃，空白的部分默认等于0
        for (int i = 0; i < n; i++) {
            if (s1.length() > i) {
                n1[i] = s1.charAt(i);
            }
            if (s2.length() > i) {
                n2[i] = s2.charAt(i);
            }
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        next = new int[e.length];
        next[0] = -1;
        // kmp算法求next数组
        for (int i = 1, j = -1; i < e.length; i++) {
            while (j >= 0 && e[j + 1] != e[i]) {
                j = next[j];
            }
            if (e[j + 1] == e[i]) {
                j++;
            }
            next[i] = j;
        }
        return dfs(true, true, 0, -1);
    }

    /**
     * limit1表示是否有下界限制，limit2表示上界限制。idx表示正放第几个字符，m表示已覆盖evil的下标
     *
     * @param limit1
     * @param limit2
     * @param idx
     * @param m
     * @return
     */
    private int dfs(boolean limit1, boolean limit2, int idx, int m) {
        // 当m == e.length - 1表示已经完全覆盖evil字符串，此时不满足要求直接返回0，结束dfs
        if (m == e.length - 1) {
            return 0;
        }
        // idx == n时已经放完了全部字符串，已经放好的字符构成一个答案返回1。
        if (idx == n) {
            return 1;
        }
        // 已经计算过的直接返回。
        if (!limit1 && !limit2 && dp[idx][m + 1] != -1) {
            return dp[idx][m + 1];
        }
        // 因为n1[idx]可能是0，减去'a'的时候变成负数，所以要至少为0
        int down = limit1 ? Math.max(0, n1[idx] - 'a') : 0;
        int up = limit2 ? n2[idx] - 'a' : 25;
        int sum = 0;
        for (int i = down; i <= up; i++) {
            int k = m;
            while (k >= 0 && e[k + 1] - 'a' != i) {
                k = next[k];
            }
            if (e[k + 1] - 'a' == i) {
                k++;
            }
            sum = (sum + dfs(limit1 && i == down, limit2 && i == up, idx + 1, k)) % MOD;
        }
        if (!limit2 && !limit1) {
            dp[idx][m + 1] = sum;
        }
        return sum;
    }
}
