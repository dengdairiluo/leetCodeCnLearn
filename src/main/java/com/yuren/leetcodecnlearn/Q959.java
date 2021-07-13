package com.yuren.leetcodecnlearn;

public class Q959 {
    public int regionsBySlashes1(String[] grid) {
        int N = grid.length;
        UF uf = new UF(4 * N * N);
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int root = 4 * (N * r + c);
                char ch = grid[r].charAt(c);
                if (ch != '/') {
                    uf.union(root + 0, root + 1);
                    uf.union(root + 2, root + 3);
                }
                if (ch != '\\') {
                    uf.union(root + 0, root + 3);
                    uf.union(root + 1, root + 2);
                }

                if (r > 0) uf.union(root + 0, root - 4 * N + 2);
                if (r < N - 1) uf.union(root + 2, root + 4 * N);
                if (c > 0) uf.union(root + 3, root - 4 + 1);
                if (c < N - 1) uf.union(root + 1, root + 4 + 3);
            }
        }

        return uf.count();
    }
}

class UF {
    private int count;
    private int[] parent, size;

    public UF(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public int count() {
        return count;
    }

    private final int[][] E = {{-1, -1, '\\'}, {-1, 0, '/'}, {0, -1, '/'}, {0, 0, '\\'}};
    private int n, m;
    private String[] g;
    private int[] v;    // vis
    public int regionsBySlashes2(String[] grid) {
        g = grid;
        n = g.length;
        m = g[0].length();
        v = new int[n + 1];
        int res = 2;
        for (int i = 0; i <= n; ++i) {
            if (!gv(i, 0)) res += dfs(i, 0, -233, -233);
            if (!gv(i, m)) res += dfs(i, m, -233, -233);
        }
        for (int i = m - 1; i > 0; --i) {
            if (!gv(0, i)) res += dfs(0, i, -233, -233);
            if (!gv(n, i)) res += dfs(n, i, -233, -233);
        }
        for (int i = n - 1; i > 0; --i) for (int j = m - 1; j > 0; --j) {
            if (!gv(i, j)) res += dfs(i, j, -233, -233);
        }
        return res >> 1;
    }

    private int dfs(int x, int y, int fx, int fy) {
        if (gv(x, y)) return 1;
        sv(x, y);
        int res = 0;
        if (fx != -233 && (x == 0 || y == 0 || x == n || y == m)) res = 2;
        for (int[] e : E) {
            int ex = x + e[0], ey = y + e[1];
            if (ex < 0 || ex >= n || ey < 0 || ey >= m || g[ex].charAt(ey) != e[2]) continue;
            if (ex == x) ++ex;
            if (ey == y) ++ey;
            if (ex == fx && ey == fy) continue;
            res += dfs(ex, ey, x, y);
        }
        return res;
    }

    private boolean gv(int x, int y) { return (v[x] & (1 << y)) != 0; } // get vis
    private void sv(int x, int y) { v[x] |= (1 << y); }                 // set vis
}
