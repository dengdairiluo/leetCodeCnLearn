package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-05-02 23:14
 */
public class Q1252 {
    public int oddCells(int m, int n, int[][] indices) {
        int[] row = new int[m];
        int[] column = new int[n];
        for (int[] index : indices) {
            row[index[0]]++;
            row[index[0]] %= 2;
        }
        for (int[] index : indices) {
            column[index[1]]++;
            column[index[1]] %= 2;
        }

        int x = 0;
        for (int t : row) {
            x += t;
        }
        int y = 0;
        for (int t : column) {
            y += t;
        }

        return m * y + n * x - 2 * x * y;


    }
}
