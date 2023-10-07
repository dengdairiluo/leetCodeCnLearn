package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-07 22:49
 */
public class Q1966 {
    public int binarySearchableNumbers(int[] nums) {
        int start = 0;
        int[] incArr = new int[nums.length];
        incArr[0] = nums[0];
        int max = incArr[0];
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > max) {
                // 比左边所有数都大，放入熟组
                max = nums[i];
                incArr[++start] = nums[i];
            } else {
                // 比左边数小，把大于这个数的都删掉
                while (start >= 0 && incArr[start] > nums[i]) {
                    start--;
                }
            }
        }

        return start + 1;
    }
}
