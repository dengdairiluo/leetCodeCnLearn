package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-06 下午11:41
 */
public class Q2518 {
    private static final int MOD = (int) 1e9 + 7;

    public int countPartitions(int[] nums, int k) {
        long sum = 0L;
        for (int x : nums) sum += x;
        if (sum < k * 2) return 0;
        int ans = 1;
        int[] f = new int[k];
        f[0] = 1;
        for (int x : nums) {
            ans = ans * 2 % MOD;
            for (int j = k - 1; j >= x; --j)
                f[j] = (f[j] + f[j - x]) % MOD;
        }
        for (int x : f)
            ans = (ans - x * 2 % MOD + MOD) % MOD; // 保证答案非负
        return ans;
    }
}
