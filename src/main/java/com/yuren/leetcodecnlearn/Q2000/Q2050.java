package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-13 23:35
 */
public class Q2050 {
    // 链式前向星
    public static int minimumTime(int n, int[][] relations, int[] time) {
        int maxN = n + 1;
        int maxM = relations.length + 1;
        int[] head = new int[maxN];
        int[] in = new int[maxN];
        int[] next = new int[maxM];
        int[] to = new int[maxM];
        int cnt = 1;
        for (int[] edge : relations) {
            int u = edge[0], v = edge[1];
            next[cnt] = head[u];
            to[cnt] = v;
            head[u] = cnt++;
            in[v]++;
        }
        int[] queue = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i <= n; i++)
            if (in[i] == 0) queue[r++] = i;
        int[] cost = new int[n + 1];
        int ans = 0;
        while (l != r) {
            int u = queue[l++];
            cost[u] += time[u - 1];
            ans = Math.max(ans, cost[u]);
            for (int i = head[u]; i != 0; i = next[i]) {
                int v = to[i];
                cost[v] = Math.max(cost[v], cost[u]);
                if (--in[v] == 0) queue[r++] = v;
            }
        }
        return ans;
    }
}
