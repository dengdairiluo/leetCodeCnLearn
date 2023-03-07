package com.yuren.leetcodecnlearn.Q400;

import java.util.ArrayList;
import java.util.List;

public class Q442 {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        //int cnt[] = new int[n+1];
        List<Integer> ans = new ArrayList<>();

        for (int i : nums) {
            nums[(i - 1) % n] = nums[(i - 1) % n] + n;

        }
        for (int i = 0; i < n; i++) {
            if (nums[i] < 3 * n + 1 && nums[i] > 2 * n) {
                ans.add(i + 1);
            }
        }
        return ans;

    }
}
