package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-07 22:11
 */
public class Q2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        int l = 0, r = nums.length - 1;
        int[] res = new int[nums.length];
        for (int num : nums) {
            if (num < pivot) {
                res[l] = num;
                l++;
            } else if (num > pivot) {
                res[r] = num;
                r--;
            }
        }
        for (int i = l; i <= r; i++) {
            res[i] = pivot;
        }
        reverse(res, r + 1, res.length - 1);
        return res;
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
            left++;
            right--;
        }
    }
}
