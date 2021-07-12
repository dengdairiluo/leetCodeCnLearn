package com.yuren.leetcodecnlearn;

import java.util.Arrays;

public class Q1198 {
    public int smallestCommonElement(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[] pos = new int[n];
        for (int j = 0; j < m; ++j) {
            boolean found = true;
            for (int i = 1; i < n && found; ++i) {
                pos[i] = Arrays.binarySearch(mat[i], pos[i], m, mat[0][j]);
                if (pos[i] < 0) {
                    found = false;
                    pos[i] = -pos[i] - 1;
                    if (pos[i] >= m) {
                        return -1;
                    }
                }
            }
            if (found) {
                return mat[0][j];
            }
        }
        return -1;
    }
}
