package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-15 下午11:49
 */
public class Q2539 {
    private static final long[] FACTORIAL;
    private static final int MOD = 1_000_000_000 + 7;

    // 实现计算阶乘
    static {
        FACTORIAL = new long[10001];
        FACTORIAL[0] = 1;

        for (int i = 1; i <= 10000; i++) {
            FACTORIAL[i] = FACTORIAL[i - 1] * i;
            FACTORIAL[i] %= MOD;
        }
    }


    public int countGoodSubsequences(String s) {
        if (s.length() == 0) {
            return 0;
        }
        // 统计26个字符 每个字符穿线的次数 过程中 记录最大出现次数
        int[] count = new int[26];
        int max = 0;
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
            max = Math.max(max, count[ch - 'a']);
        }
        // 从 1到 max 出现次数 遍历 每个出现次数，表示每个字母 如果选择的话 要选择的个数
        long totalCount = 0;
        for (int i = 1; i <= max; i++) {
            // 每个字母的个数
            int eachCharCount = i;
            long cur = 1;
            for (int j = 0; j < 26; j++) {
                // 枚举每个字母
                if (count[j] < eachCharCount) {
                    continue;
                }
                // 字母个数足够 从 当前字母个数中选择 eachCharCount 个字母 有多少中组合
                cur += ((cur * combination(count[j], eachCharCount)) % MOD);
                cur %= MOD;
            }
            totalCount += ((cur - 1 + MOD) % MOD);
            totalCount %= MOD;
        }
        // 内部 遍历 1-26 每个字母 按照出现个数 算一个组合数字 组合也要加上 不选择的种类数 跟之前的 做乘法
        // 减去所有都不选择的个数
        return (int) totalCount;
    }


    /**
     * 从 base 获取 target个 组合数量
     *
     * @param base
     * @param target
     * @return
     */
    private long combination(int base, int target) {
        if (target > base) {
            return 0;
        }
        // 小于等于
        long b = multiply(FACTORIAL[base - target], FACTORIAL[target]);
        return divide(FACTORIAL[base], b);
    }


    /**
     * 带mod的乘法
     *
     * @param a
     * @param b
     * @return
     */
    private long multiply(long a, long b) {
        long res = a * b;
        res %= MOD;
        return res;
    }


    /**
     * 除法带mod
     *
     * @param a
     * @param b
     * @return
     */
    private long divide(long a, long b) {
        return multiply(a, inv(b));
    }

    /**
     * 求b的倒数的逆元
     *
     * @param target
     * @return
     */
    private long inv(long target) {
        long tmp = target;
        long n = MOD - 2;
        // 快速幂方法
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res = multiply(res, tmp);
            }
            tmp = multiply(tmp, tmp);
            n /= 2;
        }
        return res;
    }

}
