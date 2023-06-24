package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-24 22:13
 */
public class Q1714 {
    static final int MOD = (int) 1e9 + 7;

    public int[] solve(int[] nums, int[][] queries) {
        // q.len 1.5 * 10^5
        // 简单模拟一定超时
        int n = nums.length, m = queries.length;
        int sqrtN = (int) Math.floor(Math.sqrt(n));
        int[][] suf = new int[sqrtN + 1][n];
        for (int delta = 1; delta <= sqrtN; ++delta) {
            for (int start = n - 1; start > n - 1 - delta; --start) {
                suf[delta][start] = nums[start];
            }
            for (int start = n - 1 - delta; start >= 0; --start) {
                suf[delta][start] = (nums[start] + suf[delta][start + delta]) % MOD;
            }
        }

        int[] ans = new int[m];
        int idx = 0;
        for (int[] q : queries) {
            if (q[1] <= sqrtN) {
                ans[idx++] = suf[q[1]][q[0]];
            } else {
                long t = 0;
                for (int i = q[0]; i < n; i += q[1]) {
                    t += nums[i];
                }
                t = t % MOD;
                ans[idx++] = (int) t;
            }
        }
        return ans;
    }
}
