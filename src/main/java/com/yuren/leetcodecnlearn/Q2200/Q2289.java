package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-11 23:51
 */
public class Q2289 {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        int[] stack = new int[n];
        int[] dp = new int[n];
        int top = -1, result = 0;

        for (int i = n - 1; i >= 0; --i) {

            int x = nums[i], count = dp[i];
            while (top != -1 && nums[stack[top]] < x)
                count = Math.max(++count, dp[stack[top--]]);

            dp[i] = count;
            if (count > result)
                result = count;
            stack[++top] = i;
        }
        return result;

    }
}
