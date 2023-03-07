package com.yuren.leetcodecnlearn.Q700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-05-15 23:27
 */
public class Q724 {
    public int pivotIndex(int[] nums) {
        int total = 0;  // 总和
        int sum = 0;    // 左侧数
        for (int a : nums) { // 计算总和
            total += a;
        }
        for (int i = 0; i < nums.length; i++) {
            if (sum == total - nums[i] - sum) {  // 左侧数==总和-当前数-左侧数（即右侧数）
                return i;
            }
            sum += nums[i]; // 左侧数+当前数
        }
        return -1;
    }
}
