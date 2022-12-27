package com.yuren.leetcodecnlearn.Q1300;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-27 23:39
 */
public class Q1245 {
    //建图
    //出边数组
    OutEdge[] outEdges;
    //head[u]表示u节点的第一条出边
    int[] head;
    //边的编号
    int index;
    int ans;
    boolean[] visited;

    public int treeDiameter(int[][] edges) {
        int m = edges.length;
        int n = m + 1;
        buildGraph(n, m);
        visited = new boolean[n];
        for (int[] edge : edges) {
            int x0 = edge[0];
            int x1 = edge[1];
            add(x0, x1, 1);
            add(x1, x0, 1);
        }
        ans = 0;
        dfs(0);
        return ans;
    }

    private int dfs(int u) {
        visited[u] = true;
        //记录从u往下走的最长路径的长度
        int d1 = 0;
        //记录从u往下走的第二长路径的长度
        int d2 = 0;
        for (int i = head[u]; i != -1; i = outEdges[i].nextEdge) {
            int j = outEdges[i].to;
            if (visited[j]) {
                continue;
            }
            int d = dfs(j) + outEdges[i].weight;
            if (d >= d1) {
                d2 = d1;
                d1 = d;
            } else if (d > d2) {
                d2 = d;
            }
        }
        ans = Math.max(ans, d1 + d2);
        return d1;
    }

    private void buildGraph(int points, int edges) {
        outEdges = new OutEdge[edges * 2];
        head = new int[points];
        Arrays.fill(head, -1);
        index = 0;
    }

    private void add(int father, int son, int weight) {
        outEdges[index] = new OutEdge(son, weight, head[father]);
        head[father] = index;
        index++;
    }

    //出边
    private static class OutEdge {
        //终点
        int to;
        int weight;
        //下一条出边
        int nextEdge;

        public OutEdge(int to, int weight, int nextEdge) {
            this.to = to;
            this.weight = weight;
            this.nextEdge = nextEdge;
        }
    }
}
