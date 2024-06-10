package com.yuren.leetcodecnlearn.Q2400;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-10 下午11:11
 */
public class Q2467 {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<Integer>[] e = new List[n];
        for (int i = 0; i < n; i++) {
            e[i] = new ArrayList<>();
        }
        for(int[] edge : edges) {
            e[edge[0]].add(edge[1]);
            e[edge[1]].add(edge[0]);
        }

        List<Integer> bpath = new ArrayList<>(n);
        dfsBPath(e, bob, -1, bpath);

        for (int i = bpath.size() - 1; i > (bpath.size() - 1) / 2; i--) {
            amount[bpath.get(i)] = 0;
        }
        if (bpath.size() % 2 == 1) {
            int middle = bpath.get(bpath.size() / 2);
            amount[middle] = amount[middle] / 2;
        }
        return dfs(e, 0, -1, amount);

    }

    private boolean dfsBPath(List<Integer>[] e, int node, int preNode, List<Integer> bpath) {
        if (node == 0) {
            bpath.add(0);
            return true;
        }
        for (int i = 0; i < e[node].size(); i++) {
            int next = e[node].get(i);
            if (next != preNode && dfsBPath(e, next, node, bpath)) {
                bpath.add(node);
                return true;
            }
        }
        return false;
    }

    private int dfs(List<Integer>[] e, int root, int rootParent, int[] amount) {
        int max = Integer.MIN_VALUE;
        boolean hasChild = false;
        for (int i = 0; i < e[root].size(); i++) {
            int child = e[root].get(i);
            if (child != rootParent) {
                max = Math.max(max, dfs(e, child, root, amount));
                hasChild = true;
            }
        }
        return hasChild ? (max + amount[root]) : amount[root];
    }
}
