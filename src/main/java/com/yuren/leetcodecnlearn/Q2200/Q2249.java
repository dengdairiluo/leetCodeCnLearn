package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-20 23:16
 */
public class Q2249 {
    public int countLatticePoints(int[][] circles) {
        int n = circles.length, c = 0, v = 0;
        int[][] d = new int[201][202];
        for (int[] circle : circles) {
            int cx = circle[0], cy = circle[1], r = circle[2], len = r;
            for (int up = 0; up <= r; up++) {
                while (len * len + up * up > r * r) {
                    len--;
                }
                d[cy + up][cx - len] += 1;
                d[cy + up][cx + len + 1] -= 1;
                d[cy - up][cx - len] += 1;
                d[cy - up][cx + len + 1] -= 1;
            }
        }
        for (int y = 0; y <= 200; y++) {
            for (int x = 0; x <= 200; x++) {
                v += d[y][x];
                if (v > 0) {
                    c++;
                }
            }
            v = 0;
        }
        return c;
    }
}
