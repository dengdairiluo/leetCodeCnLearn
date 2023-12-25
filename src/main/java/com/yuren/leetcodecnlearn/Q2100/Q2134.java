package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-25 22:41
 */
public class Q2134 {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int m = n - sum;

        int cur = 0;
        for (int i = 0; i < m; i++) {
            cur += nums[i];
        }
        int min = cur, preCur = cur;
        for (int i = 1; i <= m; i++) {
            preCur += nums[n - i] - nums[m - i];
            min = Math.min(min, preCur);
        }
        int postCur = cur;
        for (int i = m; i < n; i++) {
            postCur += nums[i] - nums[i - m];
            min = Math.min(min, postCur);
        }

        return min;
    }
}
