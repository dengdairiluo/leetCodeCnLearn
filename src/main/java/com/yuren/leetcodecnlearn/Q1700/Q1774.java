package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-16 23:28
 */
public class Q1774 {
    public int closestCost(int[] base, int[] top, int V) {
        boolean[] dp = new boolean[V + 5];
        int ans = Integer.MAX_VALUE;
        //判断只能选基料
        for (int x : base) {
            if (x > V) ans = Math.min(ans, x);
            else dp[x] = true;
        }
        for (int x : top) {
            //选2次
            for (int i = 0; i < 2; i++) {
                for (int j = V; j >= 0; j--) {
                    //计算大于的情况
                    if (dp[j] && j + x > V) ans = Math.min(ans, j + x);
                    if (j > x) dp[j] |= dp[j - x];
                }
            }
        }
        //ans-V:目前获得与target的差距
        for (int i = 0; i <= ans - V && i <= V; i++) if (dp[V - i]) return V - i;
        return ans;
    }
}
