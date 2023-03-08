package com.yuren.leetcodecnlearn.Q1300;

import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-18 22:53
 */
public class Q1301 {
    int n;
    char[][] c;
    int[][] cacheOfScore;
    int[][] cacheOfMethod;
    int MOD = (int) (1e9 + 7);

    public int[] pathsWithMaxScore(List<String> board) {
        // 先将其转化为二维字符数组
        n = board.size();
        cacheOfScore = new int[n + 1][n + 1];
        cacheOfMethod = new int[n + 1][n + 1];
        c = new char[n][n];
        for (int i = 0; i < n; i++) {
            c[i] = board.get(i).toCharArray();
            Arrays.fill(cacheOfScore[i], -1);
        }
        cacheOfMethod[n - 1][n - 1] = 1;
        cacheOfScore[n - 1][n - 1] = 0;
        dfs(0, 0);
        int ans = cacheOfScore[0][0] == 0 ? 0 : cacheOfScore[0][0] - c[0][0] + '0';
        return new int[]{ans, cacheOfMethod[0][0]};
    }

    /**
     * 从i,j点到终点0,0的得分及方案数
     *
     * @param i
     * @param j
     * @return
     */
    int dfs(int i, int j) {
        if (i >= n || j >= n) {
            cacheOfScore[i][j] = 0;
        } else if (cacheOfScore[i][j] == -1) {
            cacheOfScore[i][j] = 0;
            if (c[i][j] == 'X') {
                cacheOfScore[i][j] = 0;
            } else {
                if (cacheOfScore[i + 1][j] == -1) {
                    cacheOfScore[i + 1][j] = dfs(i + 1, j);
                }
                if (cacheOfScore[i][j + 1] == -1) {
                    cacheOfScore[i][j + 1] = dfs(i, j + 1);
                }
                if (cacheOfScore[i + 1][j + 1] == -1) {
                    cacheOfScore[i + 1][j + 1] = dfs(i + 1, j + 1);
                }
                int max = Math.max(cacheOfScore[i + 1][j], cacheOfScore[i + 1][j + 1]);
                max = Math.max(max, cacheOfScore[i][j + 1]);
                if (max == cacheOfScore[i + 1][j]) {
                    cacheOfMethod[i][j] = (cacheOfMethod[i][j] + cacheOfMethod[i + 1][j]) % MOD;
                }
                if (max == cacheOfScore[i + 1][j + 1]) {
                    cacheOfMethod[i][j] = (cacheOfMethod[i][j] + cacheOfMethod[i + 1][j + 1]) % MOD;
                }
                if (max == cacheOfScore[i][j + 1]) {
                    cacheOfMethod[i][j] = (cacheOfMethod[i][j] + cacheOfMethod[i][j + 1]) % MOD;
                }
                if (max != 0 || (i + 1 == n - 1 && j == n - 1) || (i == n - 1 && j + 1 == n - 1) || (i + 1 == n - 1 && j + 1 == n - 1)) {
                    cacheOfScore[i][j] = (cacheOfScore[i][j] + c[i][j] - '0' + max) % MOD;
                }
            }
        }
        return cacheOfScore[i][j];
    }
}
