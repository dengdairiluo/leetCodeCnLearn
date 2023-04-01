package com.yuren.leetcodecnlearn.Q1400;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-02 03:08
 */
public class Q1498 {
    private static final int MOD = (int) 1e9 + 7;

    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        // 预处理2的n次方
        int[] pow2arr = new int[n];
        pow2arr[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2arr[i] = (pow2arr[i - 1] << 1) % MOD;
        }

        Arrays.sort(nums);
        if (nums[0] * 2 > target) {
            return 0;
        }
        int left = 0, right = n - 1;
        long res = 0;
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                res += pow2arr[right - left] % MOD;
                left += 1;
            } else {
                right -= 1;
            }
        }
        // 注意这个 MOD 要放在括号里...
        return (int) (res % MOD);
    }
}
