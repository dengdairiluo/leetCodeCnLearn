package com.yuren.leetcodecnlearn.Q400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-11-28 23:47
 */
public class Q329 {
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};
    private int[][] matrix;
    private int max = 0;
    private int m, n;
    private int[][] len;

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        len = new int[m][n];
        if (m == 1 && n == 1) return 1;
        // list = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (len[i][j] == 0)
                    max = Math.max(dfs(i, j), max);
            }
        }

        return max;
    }

    int dfs(int x, int y) {
        if (len[x][y] != 0) return len[x][y]; //已经计算过最长递增路径就直接返回
        len[x][y]++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > m - 1 || ny < 0 || ny > n - 1) continue; //数组越界
            if (matrix[nx][ny] > matrix[x][y]) {
                len[x][y] = Math.max(len[x][y], dfs(nx, ny) + 1);
            }
        }

        return len[x][y];
    }
}
