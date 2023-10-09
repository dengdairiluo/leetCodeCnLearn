package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-09 23:38
 */
public class Q1975 {
    public long maxMatrixSum(int[][] matrix) {
        long total = 0;
        int count = 0;
        long minAbsNum = Integer.MAX_VALUE;

        for (int[] numArr : matrix) {
            for (int num : numArr) {

                // sum negative
                if (num < 0) {
                    num = -num;
                    count++;
                }

                if (num < minAbsNum) {
                    minAbsNum = num;
                }

                //get total
                total += num;
            }
        }

        return (count & 1) == 1 ? total - 2L * minAbsNum : total;
    }
}
