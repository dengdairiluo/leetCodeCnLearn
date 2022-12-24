package com.yuren.leetcodecnlearn.Q1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-05 20:39
 */
public class Q1129 {

    /**
     * BFS
     */
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        //2 <= n <= 1000
        //边的集合转换为邻接表
        ArrayList<Integer>[] redList = new ArrayList[n];
        ArrayList<Integer>[] blueList = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            redList[i] = new ArrayList<>();
            blueList[i] = new ArrayList<>();
        }
        for (int[] edge : redEdges) {
            redList[edge[0]].add(edge[1]);
        }
        for (int[] edge : blueEdges) {
            blueList[edge[0]].add(edge[1]);
        }

        boolean[] redVisited = new boolean[n];
        boolean[] blueVisited = new boolean[n];
        //BFS,<v,color,len>
        Queue<int[]> queue = new LinkedList<>();
        //0-red,1-blue
        //初始0可以走红色和蓝色两条路
        queue.add(new int[]{0, 0, 0});
        queue.add(new int[]{0, 1, 0});
        //注意，因为有红蓝两种选择，则应该有两种标记
        //标记访问
        redVisited[0] = true;
        //标记访问
        blueVisited[0] = true;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        while (!queue.isEmpty()) {
            int[] x = queue.poll();
            int v = x[0], color = x[1], len = x[2];
            //第一次访问为最小距离
            if (res[v] == -1) {
                res[v] = len;
            }
            //red
            if (color == 0) {
                for (int w : blueList[v]) {
                    if (!blueVisited[w]) {
                        //标记访问
                        blueVisited[w] = true;
                        queue.add(new int[]{w, 1, len + 1});
                    }
                }
            } else {
                for (int w : redList[v]) {
                    if (!redVisited[w]) {
                        //标记访问
                        redVisited[w] = true;
                        queue.add(new int[]{w, 0, len + 1});
                    }
                }
            }
        }
        return res;
    }

}
