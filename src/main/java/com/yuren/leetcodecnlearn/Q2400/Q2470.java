package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-11 下午11:50
 */
public class Q2470 {
    public int subarrayLCM(int[] nums, int k) {
        int n = nums.length, count = 0;
        int[] k_factors_count = new int[n];

        for (int i = n - 1; i >= 0; --i) {
            if (k % nums[i] == 0) k_factors_count[i] = ++count;
            else count = 0;
        }

        int result = 0, lcm = 0, j = 0;

        for (int i = 0; i < n; ++i) {
            if (k_factors_count[i] == 0) continue;

            lcm = nums[i];
            j = i;

            while (lcm < k && j + 1 < n && k_factors_count[j + 1] != 0) lcm = lcm(lcm, nums[++j]);

            if (j == n - 1 && lcm < k) return result;

            if (lcm == k) result += k_factors_count[j];
        }

        return result;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
