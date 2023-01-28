package com.yuren.leetcodecnlearn.Q1400;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-29 01:01
 */
public class Q1334 {
    private final static int MAX = 10001;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {


        // 定义邻接矩阵D，并初始化各个城市间距离为INT_MAX（无穷）
        int[][] distances = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(distances[i], MAX);
        }

        // 根据edges[][]初始化D[][]
        for (int[] e : edges) {
            // 无向图两个城市间的两个方向距离相同
            distances[e[0]][e[1]] = e[2];
            distances[e[1]][e[0]] = e[2];
        }

        // Floyd算法
        for (int k = 0; k < n; k++) {
            // n个顶点依次作为插入点
            for (int i = 0; i < n; i++) {
                if (i == k || distances[i][k] == MAX) {
                    continue;
                }
                for (int j = i + 1; j < n; j++) {
                    distances[i][j] = distances[j][i] = Math.min(distances[i][k] + distances[k][j], distances[i][j]);
                }

            }
        }
        // 选择出能到达其它城市最少的城市result
        int city = -1;
        int minNum = MAX;
        for (int i = 0; i < n; i++) {
            int currNum = 0;
            for (int j = 0; j < n; j++) {

                if (i != j && distances[i][j] <= distanceThreshold) {
                    currNum++;
                }

            }

            if (currNum <= minNum) {
                minNum = currNum;
                city = i;
            }

        }
        return city;

    }
}
