package com.yuren.leetcodecnlearn.Q1200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-13 00:17
 */
public class Q1284 {
    public int minFlips(int[][] mat) {
        int curr = 0;
        int m = mat.length;
        int n = mat[0].length;
        int total = m * n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int flatIndex = i * n + j;
                curr |= (mat[i][j] << flatIndex);
            }
        }
        if (Integer.bitCount(curr) == 0) {
            return 0;
        }
        int ans = total + 1;
        int max = (int) Math.pow(2, total);
        int[] directions = new int[]{0, 0, -1, 0, 1, 0};
        //i为掩码，1翻转，0不翻转
        for (int i = 0; i < max; i++) {
            int cnt = Integer.bitCount(i);
            if (cnt >= ans) {
                continue;
            }
            int now = curr;
            for (int j = 0; j < total; j++) {
                int bx = j / n;
                int by = j % n;
                if (1 == ((i >> j) & 1)) {
                    for (int k = 0; k < 5; k++) {
                        int x = directions[k] + bx;
                        int y = directions[k + 1] + by;
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            int pos = x * n + y;
                            now ^= (1 << pos);
                        }
                    }

                }
            }

            if (now == 0) {
                ans = cnt;
            }
        }
        return ans == total + 1 ? -1 : ans;
    }
}
