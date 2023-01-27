package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-27 23:05
 */
public class Q1330 {
    public int maxValueAfterReverse(int[] nums) {
        int n = nums.length;
        //不反转任何子数组时的数组值
        int raw = 0;
        for (int i = 0; i < n - 1; i++) {
            raw += Math.abs(nums[i] - nums[i + 1]);
        }
        //最大的线段左端点
        int maxL = Math.min(nums[0], nums[1]);
        //最小的线段右端点
        int minR = Math.max(nums[0], nums[1]);
        for (int i = 0; i < n - 1; i++) {
            int l = Math.min(nums[i], nums[i + 1]);
            int r = Math.max(nums[i], nums[i + 1]);
            maxL = Math.max(maxL, l);
            minR = Math.min(minR, r);
        }
        //拥有最大左端点的线段和最小右端点的线段是否相离？
        int ans = maxL > minR ? raw + 2 * (maxL - minR) : raw;
        //判断子数组的一端在原数组端点的特殊情况
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, raw - Math.abs(nums[i] - nums[i + 1]) + Math.abs(nums[0] - nums[i + 1]));
            ans = Math.max(ans, raw - Math.abs(nums[i] - nums[i + 1]) + Math.abs(nums[i] - nums[n - 1]));
        }
        return ans;
    }
}
