package com.yuren.leetcodecnlearn.Q2700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-14 03:03
 */
public class Q2717 {
    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length, p = 0, q = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) p = i;
            // 注意 n>=2
            else if (nums[i] == n) q = i;
        }
        return p + n - 1 - q - (p > q ? 1 : 0);
    }
}
