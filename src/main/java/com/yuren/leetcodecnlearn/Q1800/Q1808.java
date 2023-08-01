package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-01 23:46
 */
public class Q1808 {
    public int maxNiceDivisors(int n) {
        int N = 10_0000_0007;
        if (n <= 3) {
            return n;
        }
        int a = n / 3, b = n % 3;
        if (b == 1) {
            return (int) (quickPow(3, a - 1, N) * 4 % N);
        } else if (b == 2) {
            return (int) (quickPow(3, a, N) * 2 % N);
        } else {
            return (int) quickPow(3, a, N);
        }
    }

    /**
     * 快速求幂：
     * p^q，计算中防止溢出，对MOD求余
     */
    public long quickPow(int p, int q, int MOD) {
        long ans = 1L;
        long base = p;
        while (q != 0) {
            if ((q & 1) == 1) {
                ans = ans * base % MOD;
            }
            base = base * base % MOD;
            q >>>= 1;
        }
        return ans;
    }

}
