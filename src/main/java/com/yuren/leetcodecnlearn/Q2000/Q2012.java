package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-25 23:22
 */
public class Q2012 {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;

        //保存左边最大
        int max = nums[0];
        //保存右边最小
        int min = nums[n - 1];

        //初始化状态数组，保存当前数是否满足条件
        boolean[] sat = new boolean[n];

        //先从左开始遍历
        for (int i = 1; i <= n - 2; ++i) {
            //中间数如果大于左边最大，说明这个数左半边都满足条件
            if (max < nums[i]) {
                sat[i] = true;
                max = nums[i];
            }
        }

        //再从右开始遍历
        for (int i = n - 2; i >= 1; --i) {
            //中间数如果小于右边最小，说明这个数右半边都满足条件
            if (nums[i] < min) {
                min = nums[i];
            //不满足需要重置为false，防止只满足左边的情况
            } else {
                sat[i] = false;
            }
        }

        int res = 0;
        for (int i = 1; i <= n - 2; ++i) {
            if (sat[i]) {
                res += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                res += 1;
            }
        }

        return res;
    }
}
