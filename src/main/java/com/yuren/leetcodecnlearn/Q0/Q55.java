package com.yuren.leetcodecnlearn.Q0;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-08-27 22:50
 */
public class Q55 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int sum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i > sum) {
                return false;
            }
            sum = Math.max(i + nums[i], sum);
            if (sum >= nums.length - 1) {
                return true;
            }
        }
        return sum >= nums.length - 1;
    }
}
