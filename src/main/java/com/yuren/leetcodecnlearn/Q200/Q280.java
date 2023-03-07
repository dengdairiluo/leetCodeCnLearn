package com.yuren.leetcodecnlearn.Q200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-11-09 23:14
 */
public class Q280 {
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void wiggleSort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i += 2) {
            if (nums[i] < nums[i - 1]) {
                swap(nums, i, i - 1);
            }

            if (i < len - 1 && nums[i] < nums[i + 1]) {
                swap(nums, i, i + 1);
            }
        }
    }
}
