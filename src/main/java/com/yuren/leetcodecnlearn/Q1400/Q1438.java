package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-08 23:52
 */
public class Q1438 {
    public int longestSubarray(int[] nums, int limit) {

        int left = 0;
        int n = nums.length;

        // 最大最小数组
        int[] max = new int[n];
        int[] min = new int[n];

        int start = 0;
        int top = -1;
        int a = 0;
        int b = -1;

        // 遍历每个数
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            while (top >= start && x > max[top]) {
                top--;
            }
            while (b >= a && x < min[b]) {
                b--;
            }
            max[++top] = x;
            min[++b] = x;
            if (max[start] - min[a] > limit) {
                if (max[start] == nums[left]) {
                    start++;
                }
                if (min[a] == nums[left]) {
                    a++;
                }
                left++;
            }
        }
        return n - left;
    }
}
