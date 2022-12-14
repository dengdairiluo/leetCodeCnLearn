package com.yuren.leetcodecnlearn.Q800;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-07-25 22:49
 */
public class Q797 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        DFS(0, graph, new LinkedList<>());
        return ans;
    }

    void DFS(int ver, int[][] graph, LinkedList<Integer> list) {
        if (ver == graph.length - 1) {
            list.add(ver);
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(ver);
        for (int i = 0; i < graph[ver].length; i++) {
            DFS(graph[ver][i], graph, list);
            list.removeLast();
        }
    }
}
