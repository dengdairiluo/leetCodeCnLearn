package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-18 下午11:42
 */
public class Q2422 {
    public int minimumOperations(int[] nums) {
        int left = 0;
        int n = nums.length;
        int right = n - 1;
        int ans = 0;
        int d = 0;
        while (left <= right) {
            if (d == 0) {
                d += nums[left++];
                d -= nums[right--];
            } else if (d < 0) {
                ++ans;
                d += nums[left++];
            } else {
                ++ans;
                d -= nums[right--];
            }
        }
        return ans + (d == 0 ? 0 : 1);
    }
}
