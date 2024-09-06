package com.yuren.leetcodecnlearn.Q2600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-06 23:53
 */
public class Q2644 {
    public int maxDivScore(int[] nums, int[] divisors) {
        int cnt = -1, ans = 0;

        for (int divisor : divisors) {
            int tmp = 0;
            for (int num : nums) {
                if (num % divisor == 0) {
                    tmp++;
                }
            }

            if (tmp > cnt || (tmp == cnt && divisor < ans)) {
                cnt = tmp;
                ans = divisor;
            }
        }
        return ans;
    }
}
