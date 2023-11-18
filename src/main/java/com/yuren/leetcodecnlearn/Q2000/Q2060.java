package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-18 23:45
 */
public class Q2060 {
    int m;
    int n;
    String s1;
    String s2;
    boolean[][][] vis = new boolean[41][41][2000];

    public boolean possiblyEquals(String s1, String s2) {
        this.m = s1.length();
        this.n = s2.length();
        this.s1 = s1;
        this.s2 = s2;
        return dfs(0, 0, 0);
    }

    private boolean dfs(int i, int j, int d) {
        if (vis[i][j][d + 1000]) {
            return false;
        }
        vis[i][j][d + 1000] = true;

        if (i == m && j == n) {
            return d == 0;
        }

        for (int t = i; t < m && Character.isDigit(s1.charAt(t)); t++) {
            if (dfs(t + 1, j, d - Integer.parseInt(s1.substring(i, t + 1)))) return true;
        }
        for (int t = j; t < n && Character.isDigit(s2.charAt(t)); t++) {
            if (dfs(i, t + 1, d + Integer.parseInt(s2.substring(j, t + 1)))) return true;
        }
        if (d > 0 && i < m && !Character.isDigit(s1.charAt(i))) {
            if (dfs(i + 1, j, d - 1)) return true;
        }
        if (d < 0 && j < n && !Character.isDigit(s2.charAt(j))) {
            if (dfs(i, j + 1, d + 1)) return true;
        }
        if (d == 0 && i < m && j < n && s1.charAt(i) == s2.charAt(j)) {
            if (dfs(i + 1, j + 1, d)) return true;
        }
        return false;
    }
}
