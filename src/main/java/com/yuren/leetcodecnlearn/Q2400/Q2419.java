package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-18 下午11:34
 */
public class Q2419 {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int ans = 0;
        int t = 0;
        for (int num : nums) {
            if (num == max) {
                t++;
            } else if (num > max) {
                ans = 1;
                t = 1;
                max = num;
            } else {
                ans = Math.max(ans, t);
                t = 0;
            }

        }
        ans = Math.max(ans, t);
        return ans;
    }
}
