package com.yuren.leetcodecnlearn.Q2600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-22 23:56
 */
public class Q2614 {
    public int diagonalPrime(int[][] nums) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; ++i) {
            int x = nums[i][i];
            if (x > ans && isPrime(x))
                ans = x;
            x = nums[i][n - 1 - i];
            if (x > ans && isPrime(x))
                ans = x;
        }
        return ans;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; ++i)
            if (n % i == 0)
                return false;
        return n >= 2; // 1 不是质数
    }

}
