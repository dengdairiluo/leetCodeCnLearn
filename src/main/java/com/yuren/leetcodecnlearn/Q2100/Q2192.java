package com.yuren.leetcodecnlearn.Q2100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-23 22:38
 */
public class Q2192 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>());
        }
        //统计入度，入度为0，可以作为新的祖先节点
        int[] indegree = new int[n];
        List<Integer>[] es = new List[n];
        for (int i = 0; i < n; i++) {
            es[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            es[e[0]].add(e[1]);
            indegree[e[1]]++;
        }
        boolean[][] flag = new boolean[n][n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : es[u]) {
                indegree[v]--;
                flag[v][u] = true;
                for (int i = 0; i < n; i++) {
                    flag[v][i] |= flag[u][i];
                }
                if (indegree[v] == 0) queue.offer(v);
            }
        }
        for (int i = 0; i < n; i++) {
            List<Integer> temp = ans.get(i);
            for (int j = 0; j < n; j++) {
                if (flag[i][j]) temp.add(j);
            }
        }
        return ans;
    }
}
