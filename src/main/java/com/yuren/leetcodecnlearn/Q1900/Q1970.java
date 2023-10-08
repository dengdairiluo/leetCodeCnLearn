package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-08 23:43
 */
public class Q1970 {
    private static final int[][] cir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    int row;

    int col;

    boolean left = false;

    boolean right = false;

    int[][] grid;

    public int latestDayToCrossDone(int row, int col, int[][] cells) {
        int n = cells.length;
        this.row = row;
        this.col = col;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            this.grid = new int[row][col];
            for (int i = 0; i <= m; i++) {
                this.grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
            }
            boolean[][] f = new boolean[row][col];
            boolean ans = false;
            for (int i = 0; i < row && !ans; i++) {
                for (int j = 0; j < col && !ans; j++) {
                    if (grid[i][j] == 1 && !f[i][j]) {
                        left = false;
                        right = false;
                        dfs(i, j, f);
                        if (left && right) {
                            ans = true;
                        }
                    }
                }
            }
            if (!ans) {
                l = m + 1;
            } else {
                r = m;
            }
            this.grid = null;
        }
        return l;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        int n = cells.length;
        UF uf = new UF(row * col + 3);
        this.grid = new int[row][col];
        for (int i = 0; i < n; i++) {
            int x = cells[i][0] - 1;
            int y = cells[i][1] - 1;
            this.grid[x][y] = 1;
            if (y == 0) {
                uf.union(row * col + 1, x * col + y);
            }
            if (y == col - 1) {
                uf.union(row * col + 2, x * col + y);
            }
            int now = x * col + y;
            for (int[] c : cir) {
                int a = x + c[0];
                int b = y + c[1];
                if (a < 0 || a >= row || b < 0 || b >= col) {
                    continue;
                }
                if (grid[a][b] == 1) {
                    uf.union(now, a * col + b);
                }
            }
            if (uf.isUnion(row * col + 1, row * col + 2)) {
                return i;
            }
        }
        return -1;
    }

    void dfs(int x, int y, boolean[][] f) {
        if (x < 0 || x >= row || y < 0 || y >= col) {
            return;
        }
        if (f[x][y] || grid[x][y] == 0) {
            return;
        }
        if (y == 0) {
            left = true;
        }
        if (y == col - 1) {
            right = true;
        }
        f[x][y] = true;
        for (int[] c : cir) {
            dfs(x + c[0], y + c[1], f);
        }
    }

    private static class UF {
        int n;

        int[] id;

        public UF(int n) {
            this.n = n;
            id = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
            }
        }

        public int find(int a) {
            while (a != id[a]) {
                id[a] = id[id[a]];
                a = id[a];
            }
            return a;
        }

        public void union(int a, int b) {
            int aa = find(a);
            int bb = find(b);
            if (aa == bb) {
                return;
            }
            id[aa] = bb;
        }

        public boolean isUnion(int a, int b) {
            return find(a) == find(b);
        }
    }
}
