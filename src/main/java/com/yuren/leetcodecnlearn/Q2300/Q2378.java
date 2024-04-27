package com.yuren.leetcodecnlearn.Q2300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-27 下午10:09
 */
public class Q2378 {
    List<Integer>[] tree;
    int[][] edges;

    public long maxScore(int[][] edges) {
        int n = edges.length + 1;
        tree = new List[n];
        this.edges = edges;
        Arrays.setAll(tree, o -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            if (edges[i][0] != -1) {
                tree[edges[i][0]].add(i);
            }
        }

        long[] res = traverse(0);
        return Math.max(res[0], res[1]);
    }

    public long[] traverse(int node) {
        if (tree[node].isEmpty()) {
            return new long[]{0, 0};
        }

        long sum = 0;
        long chooseEdge = Long.MIN_VALUE;
        for (int i = 0; i < tree[node].size(); i++) {
            long[] child = traverse(tree[node].get(i));
            sum += child[0];
            chooseEdge = Math.max(chooseEdge, child[1] - child[0] + edges[tree[node].get(i)][1]);
        }

        return new long[]{Math.max(sum, chooseEdge + sum), sum};
    }

}
