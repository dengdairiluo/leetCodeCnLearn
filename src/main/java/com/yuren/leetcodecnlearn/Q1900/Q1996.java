package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-18 00:07
 */
public class Q1996 {
    public int numberOfWeakCharacters(int[][] properties) {
        //【定义】dp[i] 表示攻击力 >= i 的角色的最大防御力
        int[] dp = new int[100005];
        // 将 dp[i] 维护成攻击力 == i 的角色的最大防御力
        for (int[] ints : properties) {
            dp[ints[0]] = Math.max(dp[ints[0]], ints[1]);
        }
        // 将 dp[i] 维护成攻击力 >= i 的角色的最大防御力
        for (int i = dp.length - 2; i >= 0; i--) {
            dp[i] = Math.max(dp[i], dp[i + 1]);
        }
        int cnt = 0;
        for (int[] property : properties) {
            if (dp[property[0] + 1] > property[1]) {
                cnt++;
            }
        }
        return cnt;
    }
}
