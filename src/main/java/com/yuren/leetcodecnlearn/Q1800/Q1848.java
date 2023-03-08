package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-06-14 23:24
 */
public class Q1848 {
    public int getMinDistance(int[] nums, int target, int start) {
        // if (nums[start] == target) return 0;
        boolean i1 = true; //记录左边界是否超出范围
        boolean i2 = true; //记录右边界是否超出范围
        for (int i = 0; ; i++) {
            if (start + i >= nums.length) i2 = false;
            if (start - i < 0) i1 = false;
            if (i1 && i2) {
                if (nums[start + i] == target || nums[start - i] == target) return i;
            } else if (i1) {
                if (nums[start - i] == target) return i;
            } else {
                if (nums[start + i] == target) return i;
            }

        }

    }
}
