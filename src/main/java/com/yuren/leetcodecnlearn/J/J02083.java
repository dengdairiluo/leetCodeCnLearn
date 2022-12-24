package com.yuren.leetcodecnlearn.J;

import java.util.ArrayList;
import java.util.List;

public class J02083 {
    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void dfs(int[] nums, int idx) {
        if (idx == nums.length - 1) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
        }
        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            dfs(nums, idx + 1);
            swap(nums, i, idx);
        }
    }

}
