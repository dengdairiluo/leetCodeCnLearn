package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-05-23 10:52
 */
public class Q1863 {
    int res = 0;

    public int subsetXORSum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        dfs(nums, 0, 0);
        return res;
    }

    //i：表示来到第i个位置
    public void dfs(int[] nums, int i, int xor_sum) {
        if (i == nums.length) {
            res += xor_sum;
            return;
        }
        //当前位置要
        dfs(nums, i + 1, xor_sum ^ nums[i]);
        //当前位置不要
        dfs(nums, i + 1, xor_sum);
    }
}
