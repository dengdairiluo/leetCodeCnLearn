package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-07 下午11:45
 */
public class Q2401 {
    public int longestNiceSubarray(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) { // 枚举子数组右端点 i
            int or = 0, j = i;
            while (j >= 0 && (or & nums[j]) == 0) // nums[j] 与子数组中的任意元素 AND 均为 0
                or |= nums[j--]; // 加到子数组中
            ans = Math.max(ans, i - j);
        }
        return ans;
    }

}
