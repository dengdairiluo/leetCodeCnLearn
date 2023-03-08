package com.yuren.leetcodecnlearn.Q1100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-06 23:19
 */
public class Q1197 {
    int[][] ansArr = new int[][]{
            {0, 3, 2, 3, 2},
            {3, 2, 1, 2, 3},
            {2, 1, 4, 3, 2},
            {3, 2, 3, 2, 3},
            {2, 3, 2, 3, 4}};

    public int minKnightMoves(int x, int y) {
        if (x < 0) {
            x = -x;
        }
        if (y < 0) {
            y = -y;
        }
        int ans = 0;
        while (!(x <= 4 && y <= 4)) {
            if (x > y) {
                if (y > 0) {
                    x -= 2;
                    y -= 1;
                } else {
                    x -= 2;
                    y += 1;
                }
            } else {
                if (x > 0) {
                    y -= 2;
                    x -= 1;
                } else {
                    y -= 2;
                    x += 1;
                }
            }
            ans++;
        }
        return ans + ansArr[x][y];
    }
}
