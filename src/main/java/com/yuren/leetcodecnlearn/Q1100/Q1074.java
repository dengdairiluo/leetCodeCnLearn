package com.yuren.leetcodecnlearn.Q1100;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-15 23:51
 */
public class Q1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int submatrices = 0;
        int m = matrix.length, n = matrix[0].length;
        for (int startRow = 0; startRow < m; startRow++) {
            int[] columnSums = new int[n];
            for (int i = startRow; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    columnSums[j] += matrix[i][j];
                }
                submatrices += subarraySum(columnSums, target);
            }
        }
        return submatrices;
    }

    public int subarraySum(int[] nums, int target) {
        int subarrays = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);
        int sum = 0;
        int length = nums.length;
        for (int num : nums) {
            sum += num;
            int count = counts.getOrDefault(sum - target, 0);
            subarrays += count;
            counts.put(sum, counts.getOrDefault(sum, 0) + 1);
        }
        return subarrays;
    }
}
