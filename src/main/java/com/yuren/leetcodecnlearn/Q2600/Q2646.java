package com.yuren.leetcodecnlearn.Q2600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-07 23:07
 */
public class Q2646 {
    private List<Integer>[] g, qs;
    private int[] diff, father, color, price;

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }

        qs = new ArrayList[n];
        Arrays.setAll(qs, e -> new ArrayList<>());
        for (int[] t : trips) {
            int x = t[0], y = t[1];
            // 路径端点分组
            qs[x].add(y);
            if (x != y) {
                qs[y].add(x);
            }
        }

        root = new int[n];
        for (int i = 1; i < n; i++) {
            root[i] = i;
        }

        diff = new int[n];
        father = new int[n];
        color = new int[n];
        tarjan(0, -1);

        this.price = price;
        int[] res = dfs(0, -1);
        return Math.min(res[0], res[1]);
    }

    // 并查集模板
    private int[] root;

    private int find(int x) {
        if (root[x] != x) {
            root[x] = find(root[x]);
        }
        return root[x];
    }

    private void tarjan(int x, int fa) {
        father[x] = fa;
        // 递归中
        color[x] = 1;
        for (int y : g[x]) {
            // 未递归
            if (color[y] == 0) {
                tarjan(y, x);
                // 相当于把 y 的子树节点全部 merge 到 x
                root[y] = x;
            }
        }
        for (int y : qs[x]) {
            // color[y] == 2 意味着 y 所在子树已经遍历完
            // 也就意味着 y 已经 merge 到它和 x 的 lca 上了
            // 此时 find(y) 就是 x 和 y 的 lca
            if (y == x || color[y] == 2) {
                diff[x]++;
                diff[y]++;
                int lca = find(y);
                diff[lca]--;
                int f = father[lca];
                if (f >= 0) {
                    diff[f]--;
                }
            }
        }
        // 递归结束
        color[x] = 2;
    }

    private int[] dfs(int x, int fa) {
        int notHalve = 0, halve = 0, cnt = diff[x];
        for (int y : g[x]) {
            if (y != fa) {
                // 计算 y 不变/减半的最小价值总和
                int[] res = dfs(y, x);
                // x 不变，那么 y 可以不变，可以减半，取这两种情况的最小值
                notHalve += Math.min(res[0], res[1]);
                // x 减半，那么 y 只能不变
                halve += res[0];
                // 自底向上累加差分值
                cnt += res[2];
            }
        }
        // x 不变
        notHalve += price[x] * cnt;
        // x 减半
        halve += price[x] * cnt / 2;
        return new int[]{notHalve, halve, cnt};
    }
}
