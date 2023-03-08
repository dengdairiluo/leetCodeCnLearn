package com.yuren.leetcodecnlearn.Q1200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-17 23:42
 */
public class Q1223 {
    public int dieSimulator(int n, int[] rollMax) {
        long mod = (long) (1e9 + 7);
        long[][] dp = new long[6][16];
        long[][] pre = new long[6][16];
        long[][] change;
        //对于第一个骰子
        for (int j = 0; j < 6; j++) {
            //不是j点数
            pre[j][0] = 5;
            //j点数连续一次
            pre[j][1] = 1;
        }
        for (int i = 1; i < n; i++) {
            //对于第n=i+1个骰子，从这个骰子是否为j的视角看，连续个数为k等于n-1的连续个数为k-1（k>0时）
            for (int j = 0; j < 6; j++) {
                long sum = 0;
                //对于没有超出次数的情况，最优就是连续投
                for (int k = rollMax[j]; k > 0; k--) {
                    long tmp = pre[j][k - 1];
                    //连续投次数不变
                    dp[j][k] = tmp;
                    sum += tmp;
                }
                //对于此次不投j的情况，要考虑之前0到rollMax[j]连续情况，但是要从之前也不投j的情况中，减去不满足其他5种规则的情况
                //因为此次不投j所以还有5种情况，要乘以五
                dp[j][0] = (pre[j][rollMax[j]] + sum) * 5;
                for (int z = 0; z < 6; z++) {
                    if (z != j) {
                        dp[j][0] -= pre[z][rollMax[z]];
                    }
                }
                dp[j][0] %= mod;
            }
            change = pre;
            pre = dp;
            dp = change;
        }

        long ret = 0;
        //最后的结果是对于n个骰子，考虑6种禁手，最后一个骰子的所有情况和
        for (int j = 0; j < 16; ++j) {
            ret += pre[0][j];
            ret %= mod;
        }
        return (int) ret;
    }
}
