package com.yuren.leetcodecnlearn.Q500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-03-01 23:04
 */
public class Q548 {
    public boolean splitArray(int[] nums) {
        int n = nums.length;
        int target = 0;
        int split = 1;
        for (int i = 0; i < nums.length; i++) {
            if (n - i + 1 < 8) {
                return false;
            }
            if (split == 0 && nums[i + 1] == 0) {
                continue;
            }
            target += nums[i];
            split = nums[i + 1];
            if (process(nums, i + 2, target, 3)) {
                return true;
            }
        }
        return false;
    }

    public boolean process(int[] nums, int start, int target, int rest) {
        if (rest == 0) {
            return start >= nums.length;
        }
        if (start >= nums.length) {
            return false;
        }
        int n = nums.length;
        int sum = 0;
        int split = 1;
        for (int i = start; i < n; i++) {
            if (n - i + 1 < 2 * rest) {
                return false;
            }
            if (split == 0 && nums[i + 1] == 0) {
                continue;
            }
            sum += nums[i];
            if (sum == target) {
                if (rest == 1) {
                    if (i == n - 1) {
                        return true;
                    }
                } else {
                    split = nums[i + 1];
                    if (process(nums, i + 2, target, rest - 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
