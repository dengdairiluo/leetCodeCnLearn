package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-02 22:50
 */
public class Q2271 {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        int total = 0;
        for (int[] tile : tiles) {
            max = Math.max(tile[1], max);
            min = Math.min(tile[0], min);
            int range = tile[1] - tile[0] + 1;
            if (range >= carpetLen) {
                return carpetLen;
            }
            total += range;
        }

        if (carpetLen >= max - min + 1) {
            return total;
        }

        boolean[] tmp = new boolean[max - min + 1];
        for (int[] tile : tiles) {
            for (int i = tile[0]; i <= tile[1]; i++) {
                tmp[i - min] = true;
            }
        }

        int maxW = 0;
        int windowW = 0;
        for (int i = 0; i < carpetLen; i++) {
            if (tmp[i]) {
                windowW++;
                maxW++;
            }
        }
        for (int i = carpetLen; i < max - min + 1; i++) {
            if (tmp[i - carpetLen]) {
                windowW--;
            }
            if (tmp[i]) {
                windowW++;
            }
            maxW = Math.max(windowW, maxW);

        }
        return maxW;
    }
}
