package com.yuren.leetcodecnlearn.Q2600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-22 03:34
 */
public class Q2673 {
    public int minIncrements(int n, int[] cost) {
        int ans = 0;
        // 从最后一个非叶节点开始算
        for (int i = n / 2; i > 0; i--) {
            // 两个子节点变成一样的
            ans += Math.abs(cost[i * 2 - 1] - cost[i * 2]);
            // 累加路径和
            cost[i - 1] += Math.max(cost[i * 2 - 1], cost[i * 2]);
        }
        return ans;
    }
}

