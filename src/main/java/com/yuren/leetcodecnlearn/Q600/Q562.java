package com.yuren.leetcodecnlearn.Q600;

public class Q562 {
    public int longestLine(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int ans = 0;
        int[] horizontal = new int[M[0].length];
        int[] vertical = new int[M[0].length];
        int[] diagonal = new int[M[0].length];
        int[] antiDiagonal = new int[M[0].length];
        for (int i = 0; i != M.length; ++i) {
            int[] verticalNew = new int[M[0].length];
            int[] diagonalNew = new int[M[0].length];
            int[] antiDiagonalNew = new int[M[0].length];
            for (int j = 0; j != M[0].length; ++j) {
                if (M[i][j] == 0) {
                    horizontal[j] = 0;
                    verticalNew[j] = 0;
                    diagonalNew[j] = 0;
                    antiDiagonalNew[j] = 0;
                } else {
                    horizontal[j] = j > 0 ? horizontal[j - 1] + 1 : 1;
                    verticalNew[j] = i > 0 ? vertical[j] + 1 : 1;
                    diagonalNew[j] = i > 0 && j > 0 ? diagonal[j - 1] + 1 : 1;
                    antiDiagonalNew[j] = i > 0 && j < M[0].length - 1 ? antiDiagonal[j + 1] + 1 : 1;
                    ans = Math.max(ans, horizontal[j]);
                    ans = Math.max(ans, verticalNew[j]);
                    ans = Math.max(ans, diagonalNew[j]);
                    ans = Math.max(ans, antiDiagonalNew[j]);
                }
            }
            vertical = verticalNew;
            diagonal = diagonalNew;
            antiDiagonal = antiDiagonalNew;
        }
        return ans;
    }
}
