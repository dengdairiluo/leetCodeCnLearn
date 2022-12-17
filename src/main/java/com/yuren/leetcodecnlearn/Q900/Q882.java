package com.yuren.leetcodecnlearn.Q900;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-24 19:36
 */
public class Q882 {
    int[] distances;
    boolean[] reached;

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        //init
        distances = new int[n];
        reached = new boolean[n];

        //build graph
        Map<Integer, Map<Integer, Integer>> graph = buildGraph(edges, n);

        //djistra get shortest and reachable distances
        djistra(graph, maxMoves);

        //count sub-divdedNodes from the nodes
        int ret = 0;
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], nodeCount = edge[2];
            int sum = 0;
            sum += reached[from] ? maxMoves - distances[from] : 0;
            sum += reached[to] ? maxMoves - distances[to] : 0;
            ret += Math.min(nodeCount, sum);
        }
        for (int i = 0; i < n; i++) {
            if (reached[i]) {
                ret++;
            }
        }

        return ret;
    }

    private void djistra(Map<Integer, Map<Integer, Integer>> graph, int maxMoves) {
        Arrays.fill(distances, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0});
        distances[0] = 0;

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int curD = node[0], from = node[1];
            if (reached[from]) {
                continue;
            }
            reached[from] = true;
            //firstTime we got `from`, curD is the shortest distance to `source`
            distances[from] = curD;

            Map<Integer, Integer> nextMap = graph.get(from);
            for (int to : nextMap.keySet()) {
                if (reached[to]) {
                    continue;
                }
                if (curD + nextMap.get(to) <= maxMoves) {
                    pq.offer(new int[]{curD + nextMap.get(to), to});
                }
            }
        }
    }

    /**
     * from, <to, <stepCnt from->to>>
     *
     * @param edges
     * @param n
     * @return
     */
    private Map<Integer, Map<Integer, Integer>> buildGraph(int[][] edges, int n) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashMap<>());
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int count = edge[2] + 1;
            graph.get(from).put(to, count);
            graph.get(to).put(from, count);
        }
        return graph;
    }
}
