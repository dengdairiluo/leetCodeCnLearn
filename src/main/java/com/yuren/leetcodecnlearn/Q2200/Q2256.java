package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-24 22:50
 */
public class Q2256 {
    public int minimumAverageDifference(int[] nums) {
        long minDiff = Long.MAX_VALUE;
        int minDiffIndex = -1;
        long leftSum = 0, rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            long leftAverage = getAverage(leftSum, i + 1);
            long rightAverage = getAverage(rightSum, n - i - 1);
            long diff = Math.abs(leftAverage - rightAverage);
            if (diff < minDiff) {
                minDiff = diff;
                minDiffIndex = i;
            }
        }
        return minDiffIndex;
    }

    public long getAverage(long sum, int count) {
        return sum == 0 ? 0 : sum / count;
    }
}
