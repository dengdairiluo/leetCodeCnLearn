package com.yuren.leetcodecnlearn.Q700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-14 23:21
 */
public class Q651 {
    public int maxA(int N) {
        int[] best = new int[]{0, 1, 2, 3, 4, 5, 6, 9, 12, 16, 20, 27, 36, 48, 64, 81};
        int q = N > 15 ? (N - 11) / 5 : 0;
        return best[N - 5 * q] << 2 * q;
    }
}
