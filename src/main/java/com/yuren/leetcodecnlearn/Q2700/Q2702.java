package com.yuren.leetcodecnlearn.Q2700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-06 23:33
 */
public class Q2702 {
    public int minOperations(int[] nums, int x, int y) {
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        int low = 1, high = (maxNum - 1) / y + 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isPossible(nums, x, y, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean isPossible(int[] nums, int x, int y, int operations) {
        int xTotalRequired = 0;
        int diff = x - y;
        for (int num : nums) {
            int yRequired = (num - 1) / y + 1;
            if (yRequired <= operations) {
                continue;
            }
            int remain = num - y * operations;
            int xRequired = (remain - 1) / diff + 1;
            xTotalRequired += xRequired;
            if (xTotalRequired > operations) {
                return false;
            }
        }
        return true;
    }
}
