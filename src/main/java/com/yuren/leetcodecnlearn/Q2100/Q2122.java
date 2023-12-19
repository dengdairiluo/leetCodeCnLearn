package com.yuren.leetcodecnlearn.Q2100;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-19 23:09
 */
public class Q2122 {
    public int[] recoverArray(int[] nums) {
        int index = 1;
        int n = nums.length;
        int[] tmpArr = new int[n];
        Arrays.sort(nums);
        for (int i = 1; i < n; ++i) {
            int[] ans = get(nums, tmpArr, index++, i);
            if (ans != null) return ans;
        }
        return null;

    }

    public int[] get(int[] nums, int[] tmpArr, int index, int start) {
        int k = nums[start] - nums[0];
        if (k <= 0 || k % 2 == 1) return null;
        int[] ans = new int[nums.length / 2];
        int ansIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (tmpArr[i] != index) {
                while (start < nums.length && nums[start] < nums[i] + k) ++start;
                if (start >= nums.length || nums[start] != nums[i] + k) return null;
                ans[ansIndex++] = nums[i] + k / 2;
                tmpArr[start++] = index;
            }
        }
        return ans;
    }


}
