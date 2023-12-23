package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-23 22:39
 */
public class Q2128 {
    public boolean removeOnes(int[][] g) {
        int n = g.length;
        int m = g[0].length;
        for (int j = 0; j < m; j++)
            for (int i = 1; i < n; i++)
                if ((g[0][0] ^ g[i][0]) != (g[0][j] ^ g[i][j])) return false;

        return true;
    }
}
