package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-05 21:42
 */
public class Q2219 {
    public static long maximumSumScore(int[] nums) {
        long result = Long.MIN_VALUE, left = 0, right = 0;
        for (int num : nums) {
            right += num; // 前缀和
        }
        for (int num : nums) {
            left += num; // 维护 left
            long update = Math.max(left, right);
            if (update > result) {
                result = update; // 更新结果
            }
            right -= num; // 维护 right
        }
        return result;
    }

}
