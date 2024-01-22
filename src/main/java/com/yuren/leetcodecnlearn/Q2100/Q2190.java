package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-22 23:16
 */
public class Q2190 {
    public int mostFrequent(int[] nums, int key) {
        // 初始哈希表
        int[] counts = new int[1001];
        int result = 0;
        int maxSum = 0;

        for (int i = 1; i < nums.length; i++) {
            // 计算每次key出现时，target出现的次数
            if (nums[i - 1] == key) {
                counts[nums[i]]++;
                if (counts[nums[i]] > maxSum) {
                    result = nums[i];
                    maxSum = counts[nums[i]];
                }
            }
        }
        return result;
    }
}
