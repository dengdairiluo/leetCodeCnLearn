package com.yuren.leetcodecnlearn.Q1700;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-27 05:54
 */
public class Q1726 {
    public int tupleSameProduct(int[] nums) {
        int count = 0;
        int l = nums.length;
        int[] line = new int[(l * (l - 1)) / 2];
        int k = 0;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                line[k++] = nums[i] * nums[j];
            }
        }
        Arrays.sort(line);
        for (int i = 0; i < line.length; i++) {
            for (int j = 1; i + j < line.length; j++) {
                if (line[i] == line[i + j]) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count * 8;
    }
}
