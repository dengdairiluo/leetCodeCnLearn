package com.yuren.leetcodecnlearn;

public class Q518 {
    public int change(int amount, int[] coins) {
        int[] f = new int[amount + 1];
        //f[0][0] = 1;
        f[0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            int v = coins[i - 1];
            for (int j = v; j <= amount; j++)
                f[j] += f[j - v];
        }
        return f[amount];
    }
}
