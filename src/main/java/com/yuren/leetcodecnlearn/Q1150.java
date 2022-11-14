package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-14 23:42
 */
public class Q1150 {
    public boolean isMajorityElement(int[] nums, int target) {

        int a = getFirst(nums, target);
        int b = getLast(nums, target);
        if (a == -1 || b == -1 || b - a + 1 <= nums.length / 2) return false;
        else return true;


    }

    public int getFirst(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (r + l) >>> 1;
            if (nums[mid] == target) {
                r = mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (nums[l] == target) {
            return l;
        } else {
            return -1;
        }
    }

    public int getLast(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (r + l + 1) >>> 1;
            if (nums[mid] == target) {
                l = mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (nums[r] == target) {
            return r;
        } else {
            return -1;
        }
    }
}
