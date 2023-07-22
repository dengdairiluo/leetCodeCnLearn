package com.yuren.leetcodecnlearn.Q1700;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-22 22:23
 */
public class Q1786 {
    static final int MOD = 1000_000_007;

    static class Edge {
        int nodeId, weight;

        public Edge(int nodeId, int weight) {
            this.nodeId = nodeId;
            this.weight = weight;
        }
    }

    static class NodeState implements Comparable<NodeState> {
        int nodeId;
        int dist;

        public NodeState(int nodeId, int dist) {
            this.nodeId = nodeId;
            this.dist = dist;
        }

        @Override
        public int compareTo(NodeState other) {
            return Integer.compare(dist, other.dist);
        }
    }

    public int countRestrictedPaths(int n, int[][] edges) {

        List<Edge>[] adjIdLists = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adjIdLists[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adjIdLists[u].add(new Edge(v, weight));
            adjIdLists[v].add(new Edge(u, weight));
        }

        Queue<NodeState> queue = new PriorityQueue<>();
        queue.add(new NodeState(n, 0));

        int[] dists = new int[n + 1];
        for (int i = 1; i < n; i++) {
            dists[i] = Integer.MAX_VALUE;
        }

        int[] counts = new int[n + 1];
        counts[n] = 1;

        for (NodeState state; (state = queue.poll()) != null; ) {
            if (dists[state.nodeId] != state.dist) {
                continue;
            }

            for (Edge edge : adjIdLists[state.nodeId]) {
                if (state.dist > dists[edge.nodeId]) {
                    counts[state.nodeId] = (counts[state.nodeId] + counts[edge.nodeId]) % MOD;
                    continue;
                }
                int nextDist = state.dist + edge.weight;
                if (nextDist < dists[edge.nodeId]) {
                    dists[edge.nodeId] = nextDist;
                    queue.add(new NodeState(edge.nodeId, nextDist));
                }
            }
            if (state.nodeId == 1) {
                break;
            }
        }
        return counts[1];
    }
}
