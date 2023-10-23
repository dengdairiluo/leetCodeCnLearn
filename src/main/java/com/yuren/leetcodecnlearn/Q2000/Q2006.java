package com.yuren.leetcodecnlearn.Q2000;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-23 23:17
 */
public class Q2006 {
    public int countKDifference(int[] nums, int k) {
        int hash[] = new int[101];
        int sum = 0;
        Arrays.fill(hash, 0);
        for (int num : nums) {
            ++hash[num];
        }
        for (int i = k + 1; i <= 100; i++) {
            sum += hash[i - k] * hash[i];
        }
        return sum;
    }
}
