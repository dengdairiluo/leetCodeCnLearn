package com.yuren.leetcodecnlearn.Q300;

public class Q357 {
    public int countNumbersWithUniqueDigits(int n) {
        //个位为0，
        if (n == 0) {
            return 1;
        }
        int res = 0;
        int[] dp = new int[n];
        //初始化
        dp[0] = 9;
        //分别计算 i位数 不包含0时对应的数量
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] * (9 - i);
        }
        //最终结果加上不包含0的情况
        for (int i = 0; i < n; i++) {
            res += dp[i];
        }
        //最终结果加上包含0的情况
        for (int i = 2; i <= n; i++) {
            res += dp[i - 2] * (i - 1);
        }
        //加上0这种特殊情况
        return res + 1;
    }
}
