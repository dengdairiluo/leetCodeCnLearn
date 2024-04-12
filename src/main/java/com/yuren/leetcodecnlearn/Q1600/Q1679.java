package com.yuren.leetcodecnlearn.Q1600;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-11 02:29
 */
public class Q1679 {
    public int maxOperations(int[] nums, int k) {
        int result = 0;
        //排序
        Arrays.sort(nums);
        //头尾指针
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            //刚好相等。两个指针都往中间移动
            if (k == sum) {
                result++;
                i++;
                j--;
                //两数之和太小，左指针右移，让和变大
            } else if (k > sum) {
                i++;
                //两数之和太大，右指针左移，让和变小
            } else {
                j--;
            }
        }
        return result;
    }
}
