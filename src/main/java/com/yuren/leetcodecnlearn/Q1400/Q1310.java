package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-20 23:48
 */
public class Q1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {

        int len = arr.length;
        int qlen = queries.length;
        int[] xorArr = new int[len];
        xorArr[0] = arr[0];
        for (int i = 1; i < len; i++) xorArr[i] = arr[i] ^ xorArr[i - 1];

        int[] res = new int[qlen];
        int temp = 0;
        for (int i = 0; i < qlen; i++) {

            temp = queries[i][0] - 1 >= 0 ? xorArr[queries[i][0] - 1] : 0;
            res[i] = temp ^ xorArr[queries[i][1]];
        }
        return res;
    }
}
