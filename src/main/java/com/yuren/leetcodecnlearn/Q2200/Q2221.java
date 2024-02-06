package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-06 23:20
 */
public class Q2221 {
    public static int triangularSum(int[] nums) {
        int res = 0;
        int c = 1;
        int n = nums.length;
        for (int j = 0; j < n - 1; j += 3) {
            for (int i = 3; i < n - j; i++) {
                nums[i - 3] = (nums[i - 3] + 3 * nums[i - 2] + 3 * nums[i - 1] + nums[i]) % 10;
            }
        }
        if (n % 3 == 1) return nums[0];
        else if (n % 3 == 2) return (nums[0] + nums[1]) % 10;
        return (nums[0] + 2 * nums[1] + nums[2]) % 10;
    }
}
