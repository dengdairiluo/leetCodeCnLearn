package com.yuren.leetcodecnlearn.Q2700;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-11-07 23:50
 */
public class Q2768 {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        long[] arr = new long[5];
        long remain = (long) (m - 1) * (n - 1);
        Set<Long> coordinatesSet = new HashSet<>();
        for (int[] coordinate : coordinates) {
            coordinatesSet.add(getHash(coordinate[0], coordinate[1], n));
        }
        Set<Long> topLeftSet = new HashSet<>();
        for (int[] coordinate : coordinates) {
            int x = coordinate[0], y = coordinate[1];
            int minRow = Math.max(x - 1, 0), minCol = Math.max(y - 1, 0);
            int maxRow = Math.min(x, m - 2), maxCol = Math.min(y, n - 2);
            for (int topLeftRow = minRow; topLeftRow <= maxRow; topLeftRow++) {
                for (int topLeftCol = minCol; topLeftCol <= maxCol; topLeftCol++) {
                    long start = getHash(topLeftRow, topLeftCol, n);
                    if (topLeftSet.add(start)) {
                        int count = 0;
                        for (int i = 0; i < 2; i++) {
                            for (int j = 0; j < 2; j++) {
                                int row = topLeftRow + i, col = topLeftCol + j;
                                if (coordinatesSet.contains(getHash(row, col, n))) {
                                    count++;
                                }
                            }
                        }
                        arr[count]++;
                        remain--;
                    }
                }
            }
        }
        arr[0] = remain;
        return arr;
    }

    public long getHash(int x, int y, int n) {
        return (long) x * n + y;
    }
}
