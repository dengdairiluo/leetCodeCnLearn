package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-12-14 23:45
 */
public class Q375 {
    private static final int N = 210;
    private static final int[][] CACHE = new int[N][N];

    public int getMoneyAmount(int n) {
        return dfs(1, n);
    }

    int dfs(int l, int r) {
        if (l >= r) {
            return 0;
        }
        if (CACHE[l][r] != 0) {
            return CACHE[l][r];
        }
        int ans = 0x3f3f3f3f;
        for (int x = l; x <= r; x++) {
            // 当选择的数位 x 时，至少需要 cur 才能猜中数字
            int cur = Math.max(dfs(l, x - 1), dfs(x + 1, r)) + x;
            // 在所有我们可以决策的数值之间取最优
            ans = Math.min(ans, cur);
        }
        CACHE[l][r] = ans;
        return ans;
    }
}
