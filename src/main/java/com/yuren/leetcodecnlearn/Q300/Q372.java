package com.yuren.leetcodecnlearn.Q300;

public class Q372 {
    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        return dfs(a % MOD, b, b.length - 1);
    }

    private int dfs(int a, int[] b, int idx) {
        if (idx == -1 || a == 1) return 1;
        return qPow(dfs(a, b, idx - 1), 10) * qPow(a, b[idx]) % MOD;
    }

    private int qPow(int a, int b) {
        int ans = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) != 0) ans = ans * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return ans;
    }
}
