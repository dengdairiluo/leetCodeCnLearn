package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-30 23:24
 */
public class Q1568 {

    private int row, col;

    private int[][] mat, ids;

    private final int[] dx = new int[]{-1, 0, 1, 0};

    private final int[] dy = new int[]{0, 1, 0, -1};

    private int[] fa, dfn, low;

    private int t;

    private int find(int x) {
        if (fa[x] == x) {
            return x;
        } else {
            return fa[x] = find(fa[x]);
        }
    }

    private boolean check(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    public int minDays(int[][] grid) {
        mat = grid;
        row = mat.length;
        col = mat[0].length;

        // 并查集求连通分量
        ids = new int[row][col];
        int id = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    ids[i][j] = ++id;
                }
            }
        }
        fa = new int[id + 1];
        dfn = new int[id + 1];
        low = new int[id + 1];
        for (int i = 0; i <= id; i++) {
            fa[i] = i;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k], y = j + dy[k];
                        if (check(x, y) && mat[x][y] == 1) {
                            int r1 = find(ids[i][j]);
                            int r2 = find(ids[x][y]);
                            if (r1 == r2) {
                                continue;
                            }
                            fa[r2] = r1;
                        }
                    }
                }
            }
        }
        int cnt = 0;
        for (int i = 1; i <= id; i++) {
            if (fa[i] == i) {
                cnt++;
            }
        }
        if (cnt == 0 || cnt > 1) {
            return 0;
        }

        // tarjan求割点
        return tarjan() || id == 1 ? 1 : 2;
    }

    private boolean tarjan() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }
                if (dfs(i, j, ids[i][j])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int root) {
        dfn[ids[i][j]] = low[ids[i][j]] = ++t;
        int cnt = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (!check(x, y) || mat[x][y] != 1) {
                continue;
            }
            if (dfn[ids[x][y]] == 0) {
                if (ids[i][j] == root) {
                    cnt++;
                }
                if (dfs(x, y, root)) {
                    return true;
                }
                low[ids[i][j]] = Math.min(low[ids[i][j]], low[ids[x][y]]);
                if (ids[i][j] != root && low[ids[x][y]] >= dfn[ids[i][j]]) {
                    return true;
                }
            }
            low[ids[i][j]] = Math.min(low[ids[i][j]], dfn[ids[x][y]]);
        }
        return ids[i][j] == root && cnt > 1;
    }
}
