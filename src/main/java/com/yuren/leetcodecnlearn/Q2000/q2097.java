package com.yuren.leetcodecnlearn.Q2000;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-06 22:39
 */
public class q2097 {
    public Map<Integer, List<Integer>> adjvex = new HashMap<>();

    //--------Hierholzer算法（逐步插入回路法）
    public List<Integer> path = new ArrayList<>();

    public void dfs(int x) {
        while (adjvex.containsKey(x) == true && !adjvex.get(x).isEmpty()) {
            int y = adjvex.get(x).get(adjvex.get(x).size() - 1);
            adjvex.get(x).remove(adjvex.get(x).size() - 1);
            dfs(y);
        }
        path.add(x);
    }

    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();
        for (int[] p : pairs) {
            int x = p[0];
            int y = p[1];
            outdegree.put(x, outdegree.getOrDefault(x, 0) + 1);
            indegree.put(y, indegree.getOrDefault(y, 0) + 1);
            adjvex.putIfAbsent(x, new ArrayList<>());
            adjvex.get(x).add(y);
        }

        List<Integer> starts = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : adjvex.entrySet()) {
            int x = entry.getKey();
            if (outdegree.get(x) > indegree.getOrDefault(x, 0)) {
                starts.add(x);
            }
        }
        int start = !starts.isEmpty() ? starts.get(0) : pairs[0][0];

        dfs(start);
        Collections.reverse(path);

        int[][] res = new int[pairs.length][];
        for (int i = 0; i < path.size() - 1; i++) {
            res[i] = new int[]{path.get(i), path.get(i + 1)};
        }
        return res;
    }
}
