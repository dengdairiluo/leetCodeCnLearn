package com.yuren.leetcodecnlearn.Q2600;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-24 00:59
 */
public class Q2679 {
    public int matrixSum(int[][] nums) {
        for (int[] row : nums)
            Arrays.sort(row);
        int ans = 0, n = nums[0].length;
        for (int j = 0; j < n; j++) {
            int mx = 0;
            for (int[] row : nums)
                mx = Math.max(mx, row[j]);
            ans += mx;
        }
        return ans;
    }
}

