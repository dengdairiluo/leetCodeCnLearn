package com.yuren.leetcodecnlearn.Q2500;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-09 00:42
 */
public class Q2587 {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length - 1] <= 0) {
            return 0;
        }
        int score = 0;
        long sum = 0;
        for (int i = nums.length - 1; i >= 0 && sum >= 0; i--) {
            sum += nums[i];
            if (sum > 0) {
                score++;
            }
        }
        return score;
    }
}
