package com.yuren.leetcodecnlearn.Q700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-24 06:59
 */
public class Q674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int ans = 1;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                count++;
            } else {
                count = 1;
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }
}
