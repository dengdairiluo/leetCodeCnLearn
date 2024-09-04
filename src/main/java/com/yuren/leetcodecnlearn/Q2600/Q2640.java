package com.yuren.leetcodecnlearn.Q2600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-04 22:57
 */
public class Q2640 {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];

        long maxSofar = nums[0];
        long runningSum = 0;

        for (int i = 0; i < nums.length; i++) {
            maxSofar = Math.max(nums[i], maxSofar);
            runningSum += (nums[i] + maxSofar);
            ans[i] = runningSum;
        }

        return ans;
    }
}
