package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-01 22:50
 */
public class Q2148 {
    public int countElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int minNum = 0;
        int maxNum = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
                maxNum = 1;
            } else if (num == max) {
                maxNum++;
            }
            if (num < min) {
                min = num;
                minNum = 1;
            } else if (num == min) {
                minNum++;
            }
        }
        return min == max ? nums.length - maxNum : nums.length - maxNum - minNum;
    }

}
