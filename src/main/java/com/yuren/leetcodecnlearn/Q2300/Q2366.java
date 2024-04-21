package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-20 下午11:38
 */
public class Q2366 {
    public long minimumReplacement(int[] nums) {
        long ans = 0L;
        int m = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; --i) {
            int k = (nums[i] - 1) / m;
            ans += k;
            m = nums[i] / (k + 1);
        }
        return ans;
    }
}
