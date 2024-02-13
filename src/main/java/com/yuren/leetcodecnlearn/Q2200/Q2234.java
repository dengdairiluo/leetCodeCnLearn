package com.yuren.leetcodecnlearn.Q2200;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-13 23:08
 */
public class Q2234 {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        Arrays.sort(flowers);
        long n = flowers.length;
        // 剪枝，此时所有花园都是完善的
        if (flowers[0] >= target) return n * full;

        // 填充后缀后，剩余可以种植的花
        long leftFlowers = newFlowers - target * n;
        for (int i = 0; i < n; ++i) {
            // 去掉多余的花
            flowers[i] = Math.min(flowers[i], target);
            // 补上已有的花
            leftFlowers += flowers[i];
        }

        long ans = 0L;
        long sumFlowers = 0L;
        // 枚举后缀长度 n-i
        for (int i = 0, x = 0; i <= n; ++i) {
            if (leftFlowers >= 0) {
                // 计算最长前缀的长度
                while (x < i && (long) flowers[x] * x - sumFlowers <= leftFlowers)
                    // 注意 x 只增不减，二重循环的时间复杂度为 O(n)
                    sumFlowers += flowers[x++];
                // 计算总美丽值
                long beauty = (n - i) * full;
                if (x > 0) beauty += Math.min((leftFlowers + sumFlowers) / x, (long) target - 1) * partial;
                ans = Math.max(ans, beauty);
            }
            if (i < n) leftFlowers += target - flowers[i];
        }
        return ans;
    }
}
