package com.yuren.leetcodecnlearn.Q1700;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-29 22:56
 */
public class Q1730 {
    private static boolean validateInputParams(int m, int n) {
        return m > 200 || m < 1 || n > 200 || n < 1;
    }

    public int getFood(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 非法参数校验
        if (validateInputParams(m, n)) {
            return -1;
        }
        // 特殊情况处理
        if (m == 1 && n == 1) {
            return -1;
        }

        // 把访问路径上的节点存入队列中
        Queue<Point> queue = new LinkedList<>();
        // 访问过的节点
        int[][] visited = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '*') {
                    queue.offer(new Point(i, j));
                    // 标记初始节点已访问
                    visited[i][j] = 1;
                    break;
                }
            }
            if (!queue.isEmpty()) {
                break;
            }
        }

        // 定义4个移动方向
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        // 初始步数为0，m=n=1的特殊场景已处理
        int minSteps = 0;

        while (!queue.isEmpty()) {
            minSteps++;
            // BFS搜索-遍历相同层级下所有节点
            // 当前队列长度一定要在循环外部定义，循环内部有插入队列操作
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Point current = queue.poll();
                assert current != null;
                int x = current.x;
                int y = current.y;

                // 对当前节点四个方向进行识别处理
                for (int j = 0; j < 4; ++j) {
                    int xNew = x + dx[j];
                    int yNew = y + dy[j];
                    // 越界判断
                    if (xNew < 0 || xNew >= m || yNew < 0 || yNew >= n) {
                        continue;
                    }
                    // 搜索到目标节点直接返回结果
                    if (grid[xNew][yNew] == '#') {
                        return minSteps;
                    }
                    // 遇到障碍物
                    if (grid[xNew][yNew] == 'X') {
                        continue;
                    }
                    // 四个方向节点是否被访问过
                    if (visited[xNew][yNew] == 1) {
                        continue;
                    } else {
                        // 未被访问过且可以走的节点标记为访问过，对下一步节点确认状态非常重要
                        // 将下一层级节点入队列标记为已访问，可以剪枝更多节点，节省计算耗时
                        visited[xNew][yNew] = 1;
                    }
                    queue.offer(new Point(xNew, yNew));
                }
            }
        }
        return -1;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
