package com.yuren.leetcodecnlearn.Q2100;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-07 22:07
 */
public class Q2160 {
    public int minimumSum(int num) {
        //转数组
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = num % 10;
            num /= 10;
        }
        //实现排序
        Arrays.sort(nums);

        return nums[0] * 10 + nums[3] + nums[1] * 10 + nums[2];
    }
}
