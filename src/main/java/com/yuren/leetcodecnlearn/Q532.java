package com.yuren.leetcodecnlearn;

import java.util.Arrays;

public class Q532 {
    public int findPairs(int[] nums, int k) {
        int n = nums.length, ans = 0;
        Arrays.sort(nums);
        //找nums[i]对应的nums[j]
        for (int i = 0; i < n; i++) {
            //找过的nums[i]不需重复找
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = nums[i] + k;
            ans += binarySearch(nums, i + 1, n - 1, target);
        }
        return ans;
    }

    public int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
