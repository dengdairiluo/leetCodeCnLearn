package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-26 23:34
 */
public class Q2076 {
    private int[] pre;
    private boolean[][] res;

    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        pre = new int[n];
        res = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            pre[i] = i;
        }
        int r = restrictions.length;
        for (int[] restriction : restrictions) {
            int x = restriction[0], y = restriction[1];
            res[x][y] = true;
            res[y][x] = true;
        }
        int m = requests.length;
        boolean[] ans = new boolean[m];
        for (int i = 0; i < m; i++) {
            int x = find(requests[i][0]), y = find(requests[i][1]);
            if (x == y) {
                ans[i] = true;
            } else {
                if (res[x][y] || res[y][x]) {
                    ans[i] = false;
                } else {
                    pre[x] = y;
                    for (int j = 0; j < n; j++) {
                        if (res[x][j]) {
                            res[y][j] = true;
                            res[j][y] = true;
                        }
                    }
                    ans[i] = true;
                }
            }
        }
        return ans;
    }

    public int find(int x) {
        int r = x;
        while (pre[r] != r) {
            r = pre[r];
        }
        int i = x, j;
        while (i != r) {
            j = pre[i];
            pre[i] = r;
            i = j;
        }
        return r;
    }
}
