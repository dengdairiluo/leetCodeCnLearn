package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-01 23:52
 */
public class Q1735 {
    int mod = 1000000007;
    static int[] js = new int[10015];
    static int[] div = new int[10015];
    static int[] prime = new int[10001];
    static int dqjs = 0;
    static boolean xyLoaded = true;

    public int[] waysToFillArray(int[][] queries) {
        if (xyLoaded) {
            for (int i = 2; i < 10001; i++) {
                if (prime[i] == 0) {
                    for (int j = i; j < 10001; j += i) {
                        prime[j] = i;
                    }
                }
            }
            js[0] = 1;
            div[0] = 1;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int n = queries[i][0], k = queries[i][1];
            int last = 0;
            int temp = 1;
            int count = 0;
            while (true) {
                if (prime[k] == last) {
                    count++;
                } else {
                    if (count != 0) {
                        temp = (int) ((long) temp * cmob(n + count - 1, count) % mod);
                    }
                    last = prime[k];
                    count = 1;
                }
                if (k <= 1) {
                    break;
                }
                k /= prime[k];
            }
            ans[i] = temp;
        }
        return ans;
    }

    private int cmob(int n, int k) {
        if (k < 1 || n < k || n == k) {
            return 1;
        }
        if (k == 1 || n - k == 1) {
            return n;
        }
        if (dqjs < n) {
            for (int i = dqjs + 1; i <= n; i++) {
                js[i] = (int) ((long) js[i - 1] * i % mod);
            }
            dqjs = n;
        }
        int res = (int) ((long) js[n] * powr(k) % mod * powr(n - k) % mod);
        return res;
    }

    private int powr(int k) {
        if (div[k] != 0) {
            return div[k];
        }
        int x = mod - 2;
        int temp = 1;
        int n = js[k];
        while (x != 0) {
            if ((x & 1) == 1) {
                temp = (int) ((long) temp * n % mod);
            }
            n = (int) ((long) n * n % mod);
            x >>= 1;
        }
        div[k] = temp;
        return temp;
    }
}
