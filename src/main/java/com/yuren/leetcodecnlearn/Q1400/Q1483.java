package com.yuren.leetcodecnlearn.Q1400;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-25 21:33
 */
public class Q1483 {
    private final int[] parent;
    private final List<Integer>[] parentLists;

    public Q1483(int n, int[] parent) {
        this.parent = parent;
        this.parentLists = new List[n];
    }

    public int getKthAncestor(int node, int k) {
        if (parentLists[node] != null) {
            if (parentLists[node].size() <= k) {
                return -1;
            } else {
                return parentLists[node].get(k);
            }
        } else {
            dfs(node);
            return getKthAncestor(node, k);
        }
    }

    private void dfs(int node) {
        List<Integer> parents = new ArrayList<>();
        while (node != -1 && this.parentLists[node] == null) {
            parents.add(node);
            node = this.parent[node];
        }
        if (node != -1) {
            parents.addAll(this.parentLists[node]);
        }

        for (int i = 0; i < parents.size(); i++) {
            if (this.parentLists[parents.get(i)] != null) {
                break;
            }
            this.parentLists[parents.get(i)] = parents.subList(i, parents.size());
        }
    }
}
