package com.yuren.leetcodecnlearn.Q800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-30 22:00
 */
public class Q896 {
    public boolean isMonotonic(int[] nums) {
        int tag = 0;
        if (nums[0] <= nums[nums.length - 1]) {
            tag = 1;
        }
        if (tag == 1) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    return false;
                }
            }
            return true;
        } else {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < nums[i + 1]) {
                    return false;
                }
            }
            return true;
        }

    }
}
