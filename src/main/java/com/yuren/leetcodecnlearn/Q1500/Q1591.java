package com.yuren.leetcodecnlearn.Q1500;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-09 23:48
 */
public class Q1591 {
    public boolean isPrintable(int[][] targetGrid) {
        int[] minI = new int[61];
        Arrays.fill(minI, 61);
        int[] maxI = new int[61];
        Arrays.fill(maxI, -1);
        int[] minJ = new int[61];
        Arrays.fill(minJ, 61);
        int[] maxJ = new int[61];
        Arrays.fill(maxJ, -1);
        int n = targetGrid.length, m = targetGrid[0].length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = targetGrid[i][j];
                set.add(val);
                minI[val] = Math.min(minI[val], i);
                maxI[val] = Math.max(maxI[val], i);
                minJ[val] = Math.min(minJ[val], j);
                maxJ[val] = Math.max(maxJ[val], j);
            }
        }
        while (!allZero(targetGrid)) {
            int value = -1;
            for (int val : set) {
                if (allValid(minI[val], minJ[val], maxI[val], maxJ[val], val, targetGrid)) {
                    beZero(minI[val], minJ[val], maxI[val], maxJ[val], targetGrid);
                    value = val;
                    break;
                }
            }
            if (value != -1) {
                set.remove(value);
            } else {
                return false;
            }
        }
        return true;
    }

    boolean allValid(int i1, int j1, int i2, int j2, int val, int[][] targetGrid) {
        for (int i = i1; i <= i2; i++) {
            for (int j = j1; j <= j2; j++) {
                if (targetGrid[i][j] != val && targetGrid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean allZero(int[][] targetGrid) {
        for (int[] ints : targetGrid) {
            for (int j = 0; j < targetGrid[0].length; j++) {
                if (ints[j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    void beZero(int i1, int j1, int i2, int j2, int[][] targetGrid) {
        for (int i = i1; i <= i2; i++) {
            for (int j = j1; j <= j2; j++) {
                targetGrid[i][j] = 0;
            }
        }
    }
}
