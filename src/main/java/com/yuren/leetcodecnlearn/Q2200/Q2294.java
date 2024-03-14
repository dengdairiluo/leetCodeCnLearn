package com.yuren.leetcodecnlearn.Q2200;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-14 22:02
 */
public class Q2294 {
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) return n;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (max < num) max = num;
            if (min > num) min = num;
        }

        int[] h = new int[max - min + 1];
        for (int val : nums) {
            h[val - min]++;
        }
        // System.out.println(Arrays.toString(h));
        int l = 0, r = 0, ans = 1;
        while (r < h.length) {
            if (h[r] == 0) {
                r++;
                continue;
            }
            if (r - l > k) {
                l = r;
                ans++;
            }
            r++;
        }
        return ans;
    }

    public int partitionArray1(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) return n;
        Arrays.sort(nums);
        int l = 0, r = 0, ans = 1;
        while (r < n) {
            if (nums[r] - nums[l] > k) {
                l = r;
                ans++;
            }
            r++;
        }
        return ans;
    }
}
