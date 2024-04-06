package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-06 下午11:42
 */
public class Q2340 {
    public int minimumSwaps(int[] nums) {
        int minIndex = 0, maxIndex = 0;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
            if (nums[i] >= nums[maxIndex]) {
                maxIndex = i;
            }
        }
        int minSwaps = minIndex + n - 1 - maxIndex;
        if (minIndex > maxIndex) {
            minSwaps--;
        }
        return minSwaps;
    }
}
