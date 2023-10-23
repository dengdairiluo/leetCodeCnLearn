package com.yuren.leetcodecnlearn.Q2000;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-23 23:13
 */
public class Q2003 {
    int index;
    int[] head, next, edge;
    boolean[] visited;

    private void add(int u, int v) {
        edge[index] = v;
        next[index] = head[u];
        head[u] = index++;
    }

    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;

        head = new int[n];
        next = new int[n];
        edge = new int[n];

        Arrays.fill(head, -1);
        index = 0;

        int j = 0;
        for (int i = 1; i < n; i++) {
            add(parents[i], i);
            if (nums[i] == 1) j = i;
        }

        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int cur = 1;
        visited = new boolean[n + 2];

        while (j != -1) {
            dfs(j, nums);
            while (visited[cur]) cur++;

            ans[j] = cur;
            j = parents[j];
        }

        return ans;
    }

    private void dfs(int u, int[] nums) {
        visited[nums[u]] = true;
        for (int i = head[u]; i != -1; i = next[i]) {
            int v = edge[i];

            if (!visited[nums[v]]) dfs(v, nums);
        }
    }
}
