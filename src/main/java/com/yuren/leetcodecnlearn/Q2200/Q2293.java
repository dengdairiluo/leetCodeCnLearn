package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-14 02:29
 */
public class Q2293 {
    public int minMaxGame(int[] nums) {
        int n = nums.length;
        while (n > 1) {
            int half = n / 2;
            int[] newNums = new int[half];
            for (int i = 0; i < half; i++) {
                if (i % 2 == 0) {
                    newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            nums = newNums;
            n /= 2;
        }
        return nums[0];
    }
}
