package com.yuren.leetcodecnlearn.Q1000;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-09 23:25
 */
public class Q1063 {
    public int validSubarrays(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        int sum = nums.length;
        int[] dpTable = new int[nums.length];
        Arrays.fill(dpTable, 0);

        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] <= nums[j]) {
                    //这一步是优化点：可以少遍历一些
                    if (dpTable[j] != 0) {
                        j = dpTable[j];
                    }
                    dpTable[i] = j;
                } else {
                    break;
                }
            }

            if (dpTable[i] != 0) {
                int count = dpTable[i] - i;
                // System.out.println(count);
                sum += count;
            }
        }

        return sum;

    }
}
