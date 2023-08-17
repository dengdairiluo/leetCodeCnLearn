package com.yuren.leetcodecnlearn.Q1800;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-17 23:38
 */
public class Q1857 {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[][] dp = new int[n][26];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[n];

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            int curColor = colors.charAt(cur) - 'a';
            dp[cur][curColor]++;
            count++;

            for (int nbr : adj.get(cur)) {
                if (--indegree[nbr] == 0) q.offer(nbr);
                for (int i = 0; i < 26; i++) {
                    dp[nbr][i] = Math.max(dp[cur][i], dp[nbr][i]);
                }
            }
        }

        if (count != n) return -1;
        int res = 0;
        for (int[] row : dp) {
            for (int i : row) {
                res = Math.max(res, i);
            }
        }

        return res;
    }
}
