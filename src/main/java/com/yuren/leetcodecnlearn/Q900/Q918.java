package com.yuren.leetcodecnlearn.Q900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-09 23:46
 */
public class Q918 {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int ans = nums[0], cur = nums[0];
        for (int i = 1; i < n; ++i) {
            cur = nums[i] + Math.max(cur, 0);
            ans = Math.max(ans, cur);
        }

        // ans is the answer for 1-interval subarrays.
        // Now, let's consider all 2-interval subarrays.
        // For each i, we want to know
        // the maximum of sum(A[j:]) with j >= i+2

        // rightsums[i] = A[i] + A[i+1] + ... + A[N-1]
        int[] rightSums = new int[n];
        rightSums[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightSums[i] = rightSums[i + 1] + nums[i];
        }

        // maxright[i] = max_{j >= i} rightsums[j]
        int[] maxRight = new int[n];
        maxRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            maxRight[i] = Math.max(maxRight[i + 1], rightSums[i]);
        }

        int leftsum = 0;
        for (int i = 0; i < n - 2; ++i) {
            leftsum += nums[i];
            ans = Math.max(ans, leftsum + maxRight[i + 2]);
        }

        return ans;
    }
}
