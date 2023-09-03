package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-03 23:59
 */
public class Q1900 {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        if (firstPlayer + secondPlayer == n + 1) {
            return new int[]{1, 1};
        }
        if (firstPlayer > n + 1 - secondPlayer) {
            return earliestAndLatest(n, n + 1 - secondPlayer, n + 1 - firstPlayer);
        }
        int m = (n + 1) >> 1;
        int min = n, max = 0;
        if (secondPlayer <= m) {
            for (int f = 1; f <= firstPlayer; f++) {
                for (int s = f + 1; s <= secondPlayer - firstPlayer + f; s++) {
                    int[] el = earliestAndLatest(m, f, s);
                    min = Math.min(el[0], min);
                    max = Math.max(el[1], max);
                }
            }
        } else {
            int _s = n + 1 - secondPlayer;
            for (int f = 1; f <= firstPlayer; f++) {
                for (int s = f + 1; s <= _s - firstPlayer + f; s++) {
                    int[] el = earliestAndLatest(m, f, s + m - _s);
                    min = Math.min(el[0], min);
                    max = Math.max(el[1], max);
                }
            }
        }
        return new int[]{min + 1, max + 1};
    }
}
