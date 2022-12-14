package com.yuren.leetcodecnlearn.Q800;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-05-18 23:25
 */
public class Q730 {
    int[][] memo, prv, nxt;
    byte[] A;
    int MOD = 1_000_000_007;

    public int countPalindromicSubsequences(String S) {
        int N = S.length();
        prv = new int[N][4];
        nxt = new int[N][4];
        memo = new int[N][N];
        for (int[] row : prv) Arrays.fill(row, -1);
        for (int[] row : nxt) Arrays.fill(row, -1);

        A = new byte[N];
        int ix = 0;
        for (char c : S.toCharArray()) {
            A[ix++] = (byte) (c - 'a');
        }

        int[] last = new int[4];
        Arrays.fill(last, -1);
        for (int i = 0; i < N; ++i) {
            last[A[i]] = i;
            System.arraycopy(last, 0, prv[i], 0, 4);
        }

        Arrays.fill(last, -1);
        for (int i = N - 1; i >= 0; --i) {
            last[A[i]] = i;
            System.arraycopy(last, 0, nxt[i], 0, 4);
        }

        return dp(0, N - 1) - 1;
    }

    public int dp(int i, int j) {
        if (memo[i][j] > 0) return memo[i][j];
        int ans = 1;
        if (i <= j) {
            for (int k = 0; k < 4; ++k) {
                int i0 = nxt[i][k];
                int j0 = prv[j][k];
                if (i <= i0 && i0 <= j) ans++;
                if (-1 < i0 && i0 < j0) ans += dp(i0 + 1, j0 - 1);
                if (ans >= MOD) ans -= MOD;
            }
        }
        memo[i][j] = ans;
        return ans;
    }
}
