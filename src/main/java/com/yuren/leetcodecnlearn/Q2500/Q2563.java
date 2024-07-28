package com.yuren.leetcodecnlearn.Q2500;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-28 下午10:18
 */
public class Q2563 {
    public int bs2(int[] nums, int i, int j, int flag) {  //找上界
        while (i <= j) {
            int t = (i + j) / 2;
            if (nums[t] > flag) j = t - 1;
            else i = t + 1;
        }
        return j;
    }

    public int bs1(int[] nums, int i, int j, int flag) {  //找下界
        while (i <= j) {
            int t = (i + j) / 2;
            if (nums[t] < flag) i = t + 1;
            else j = t - 1;
        }
        return i;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        long res = 0l;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int min = lower - nums[i];
            int max = upper - nums[i];
            int start = bs1(nums, i + 1, nums.length - 1, min);
            int end = bs2(nums, i + 1, nums.length - 1, max);
            res += (end - start + 1);

        }
        return res;
    }
}
