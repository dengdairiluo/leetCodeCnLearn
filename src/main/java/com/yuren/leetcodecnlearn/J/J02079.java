package com.yuren.leetcodecnlearn.J;

import java.util.ArrayList;
import java.util.List;

public class J02079 {
    private final List<List<Integer>> res = new ArrayList<>();
    private final List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        helper(0, nums);
        return res;
    }

    /**
     * 使用递归解决问题
     *
     * @param len
     * @param nums
     */
    public void helper(int len, int[] nums) {
        if (len == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[len]);
        helper(len + 1, nums);
        list.remove(list.size() - 1);
        helper(len + 1, nums);
    }

}
