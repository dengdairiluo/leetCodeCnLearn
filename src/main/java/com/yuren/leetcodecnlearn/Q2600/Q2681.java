package com.yuren.leetcodecnlearn.Q2600;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-25 01:05
 */
public class Q2681 {
    public int sumOfPower(int[] nums) {
        final long MOD = (long) 1e9 + 7;
        Arrays.sort(nums);
        long ans = 0, s = 0;
        // x 作为最大值
        for (long x : nums) {
            // 中间模一次防止溢出
            ans = (ans + (((x * x) % MOD) * (x + s))) % MOD;
            // 递推计算下一个 s
            s = (s * 2 + x) % MOD;
        }
        return (int) ans;
    }
}
