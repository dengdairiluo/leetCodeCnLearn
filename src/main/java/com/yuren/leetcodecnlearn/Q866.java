package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-17 23:51
 */
public class Q866 {
    public int primePalindrome(int n) {
        while (true) {
            if (n == reverse(n) && isPrime(n)) {
                return n;
            }
            n++;
            if (10_000_000 < n && n < 100_000_000) {
                n = 100_000_000;
            }
        }
    }

    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        int R = (int) Math.sqrt(n);
        for (int d = 2; d <= R; ++d) {
            if (n % d == 0) {
                return false;
            }
        }
        return true;
    }

    public int reverse(int n) {
        int ans = 0;
        while (n > 0) {
            ans = 10 * ans + (n % 10);
            n /= 10;
        }
        return ans;
    }
}
