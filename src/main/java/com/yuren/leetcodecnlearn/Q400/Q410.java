package com.yuren.leetcodecnlearn.Q400;

public class Q410 {
    public int splitArray(int[] nums, int m) {
        // 二分搜索的边界
        int left = getMax(nums);
        int right = getSum(nums);

        while (left < right) {
            int mid = left + (right - left) / 2;
            int cur = split(nums, mid);
            if (cur > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    /**
     * 限制子数组和的最大值为x，至少可以将nums分割为多少个子数组，单调递减
     *
     * @param nums
     * @param x
     * @return
     */
    public int split(int[] nums, int x) {
        // 贪心
        int count = x;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= count) {
                count -= nums[i];
            } else {
                res++;
                count = x;
                i--;
            }
        }
        return res + 1;
    }

    /**
     * 数组nums中元素的最大值
     *
     * @param nums
     * @return
     */
    public int getMax(int[] nums) {
        int res = 0;
        for (int i : nums) {
            if (i > res) {
                res = i;
            }
        }
        return res;
    }

    /**
     * 数组nums中的元素之和 *
     *
     * @param nums
     * @return
     */
    public int getSum(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res += i;
        }
        return res;
    }
}
