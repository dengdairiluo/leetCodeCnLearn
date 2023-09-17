package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-17 20:28
 */
public class Q1931 {
    private static final int MOD = 1000_000_007;

    private boolean isColorDifference(int c1, int s1, int c2, int s2, int m) {
        for (int i = 0; i + 1 < m; i++) {
            c1 += ((s1 >> i) & 1) + 1;
            c2 += ((s2 >> i) & 1) + 1;
            if ((c1 - c2) % 3 == 0) {
                return false;
            }
        }
        return true;
    }

    public int colorTheGrid(int m, int n) {
        int numStates = 1 << m - 1;
        if (n == 1) {
            return numStates * 3;
        }
        int[][] matrix = new int[numStates][numStates];
        for (int s1 = 0; s1 < numStates; s1++) {
            for (int s2 = 0; s2 < numStates; s2++) {
                if (isColorDifference(0, s1, 1, s2, m)) {
                    matrix[s1][s2]++;
                }
                if (isColorDifference(0, s1, 2, s2, m)) {
                    matrix[s1][s2]++;
                }
            }
        }

        matrix = powerMatrix(matrix, n - 1);
        long sum = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sum += num;
            }
        }
        return (int) (sum * 3 % MOD);
    }

    private int[][] powerMatrix(int[][] matrix, int n) {
        if (n == 1) {
            return matrix;
        }
        int[][] matrixN = powerMatrix(matrix, n >> 1);
        matrixN = multiplyMatrix(matrixN, matrixN);
        if ((n & 1) == 1) {
            matrixN = multiplyMatrix(matrixN, matrix);
        }
        return matrixN;
    }

    private int[][] multiplyMatrix(int[][] m1, int[][] m2) {

        int size = m1.length;

        int[][] m3 = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                long sum = 0;
                for (int k = 0; k < size; k++) {
                    sum = (sum + (long) m1[i][k] * m2[k][j]) % MOD;
                }
                m3[i][j] = (int) sum;
            }
        }

        return m3;
    }
}
