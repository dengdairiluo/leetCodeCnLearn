package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-06 23:47
 */
public class Q1746 {
    public int maxSumAfterOperation(int[] nums) {
        int dp1 = 0, dp2 = 0, max = 0;
        for (int num : nums) {
            //记录平方后的最大值
            dp1 = Math.max(dp1 + num, dp2 + num * num);
            //记录平方前的最大值
            dp2 = Math.max(num + dp2, 0);
            max = Math.max(dp1, max);
        }
        return max;
    }
}
