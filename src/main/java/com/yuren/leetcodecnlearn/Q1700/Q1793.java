package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-23 22:49
 */
public class Q1793 {
    public int maximumScore(int[] nums, int k) {
        //定义左右边界l r，最大可能分数res
        int l = k, r = k, n = nums.length, res = 0;
        while (true) {
            //向右寻找以nums[k]为最小值的好子数组
            while (r < n && nums[r] >= nums[k]) r++;
            //向左寻找以nums[k]为最小值的好子数组
            while (l >= 0 && nums[l] >= nums[k]) l--;
            //更新最大可能分数
            res = Math.max(res, (r - l - 1) * nums[k]);
            //遍历完数组，直接退出循环
            if (l < 0 && r == n) break;
            //更新nums[k] 为左右边界中的较大者
            if (l >= 0 && r < n) nums[k] = Math.max(nums[l], nums[r]);
                //左边遍历完了，更新nums[k]为右边界
            else if (l < 0) nums[k] = nums[r];
                //右边遍历完了，更新nums[k]为左边界
            else nums[k] = nums[l];
        }
        return res;
    }
}
