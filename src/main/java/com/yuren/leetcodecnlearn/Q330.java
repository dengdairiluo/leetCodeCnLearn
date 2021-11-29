package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-11-29 23:47
 */
public class Q330 {
    public int minPatches(int[] nums, int n) {
        //int会溢出
        long ach = 0;
        int idx = 0, count = 0, len = nums.length;
        while (ach < n) {
            if (idx >= len || ach + 1 < nums[idx]) {
                count++;
                ach += ach + 1;
            } else {
                ach += nums[idx];
                idx++;
            }
        }
        return count;
    }
}
