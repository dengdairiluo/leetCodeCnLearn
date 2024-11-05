package com.yuren.leetcodecnlearn.Q2700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-11-05 23:42
 */
public class Q2765 {
    public int alternatingSubarray(int[] nums) {
        int ans = -1;
        int i = 0, n = nums.length;
        while (i < n - 1) {
            if (nums[i + 1] - nums[i] != 1) {
                // 直接跳过
                i++;
                continue;
            }
            // 记录这一组的开始位置
            int i0 = i;
            // i 和 i+1 已经满足要求，从 i+2 开始判断
            i += 2;
            while (i < n && nums[i] == nums[i - 2]) {
                i++;
            }
            // 从 i0 到 i-1 是满足题目要求的（并且无法再延长的）子数组
            ans = Math.max(ans, i - i0);
            i--;
        }
        return ans;
    }
}
