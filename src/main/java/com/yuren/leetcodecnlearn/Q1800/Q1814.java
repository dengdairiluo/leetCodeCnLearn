package com.yuren.leetcodecnlearn.Q1800;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-03 00:03
 */
public class Q1814 {
    public int countNicePairs(int[] nums) {
        long MOD = 1000000007;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - this.rev(nums[i]);
        }
        Arrays.sort(nums);
        // 找相同的diff 双指针
        long goodIndexNum = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j < nums.length && nums[i] == nums[j]) {
                j++;
            }
            goodIndexNum += ((long) (j - i)) * (j - i - 1) / 2 % MOD;
            goodIndexNum %= MOD;
            i = j - 1;
        }
        goodIndexNum %= MOD;
        return (int) goodIndexNum;
    }

    public int rev(int num) {
        // 获取数字的位数
        int resultNum = 0;
        while (num != 0) {
            resultNum = resultNum * 10 + num % 10;
            num /= 10;
        }
        return resultNum;
    }
}
