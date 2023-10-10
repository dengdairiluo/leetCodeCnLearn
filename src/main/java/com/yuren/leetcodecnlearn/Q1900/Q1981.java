package com.yuren.leetcodecnlearn.Q1900;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-10 23:33
 */
public class Q1981 {
    public int minimizeTheDifference(int[][] mat, int target) {

        int numRows = mat.length;
        int numCols = mat[0].length;

        int[] minSums = new int[numRows + 1];
        for(int i = numRows - 1; i >= 0; i--) {
            int[] row = mat[i];
            Arrays.sort(row);
            minSums[i] = minSums[i + 1] + row[0];
        }

        if(target <= minSums[0]) {
            return minSums[0] - target;
        }

        int minDiff = Integer.MAX_VALUE;
        boolean[] hasSums = new boolean[1];
        hasSums[0] = true;
        int maxSum = 0;
        for(int i = 0; i < numRows; i++) {
            int[] row = mat[i];
            int maxSum1 = target - minSums[i + 1];
            boolean[] hasSums1 = new boolean[maxSum1 + 1];
            for(int j = 0; j <= maxSum; j++) {
                if(!hasSums[j]) {
                    continue;
                }
                for(int k = 0; k < numCols; k++) {
                    int sum = j + row[k];
                    if(sum >= maxSum1) {
                        if(sum == maxSum1) {
                            return 0;
                        }
                        minDiff = Math.min(minDiff, sum - maxSum1);
                    } else {
                        hasSums1[sum] = true;
                    }
                }
            }
            hasSums = hasSums1;
            maxSum = maxSum1;
            for(; !hasSums[maxSum]; maxSum--);
            minDiff = Math.min(minDiff, target - (maxSum + minSums[i + 1]));
        }

        return minDiff;
    }
}
