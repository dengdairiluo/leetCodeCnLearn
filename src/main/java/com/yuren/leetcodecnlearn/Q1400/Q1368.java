package com.yuren.leetcodecnlearn.Q1400;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-12 23:46
 */
public class Q1368 {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 四个方向 注意顺序，便于后面计算方便
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // 从m到n点的代价
        int[][] cost = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(cost[i], -1);
        }
        // （0,0）点初始化为0
        cost[0][0] = 0;
        // 双端队列，遍历时，将需要增加代价的加入队列尾部，将不需要增加代价的加入队列头部
        LinkedList<int[]> queue = new LinkedList<>();
        // 初始点加入队列
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] p = queue.poll();
                if (p[0] == m - 1 && p[1] == n - 1 || visited[p[0]][p[1]]) {
                    // 经过右下角点就跳过，因为计算通过右下角点后其他点的cost无意义
                    continue;
                }
                // 计算这个点的方向
                int val = grid[p[0]][p[1]];
                visited[p[0]][p[1]] = true;
                // 计算四个方向 分别计算往 右 左 下 上
                for (int j = 0; j < 4; j++) {
                    // 计算x轴
                    int x = p[0] + dir[j][0];
                    // 计算y轴
                    int y = p[1] + dir[j][1];
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;  // 不满足条件
                    }
                    // 如果当前节点是上一个节点方向指向的节点，那么就是0，即代价不增加，否则加1
                    int add = j == val - 1 ? 0 : 1;
                    if (cost[x][y] == -1 || cost[x][y] > cost[p[0]][p[1]] + add) {
                        // 更新cost值
                        cost[x][y] = cost[p[0]][p[1]] + add;
                        if (add == 0) {
                            // 如果是0 就加入队头
                            queue.addFirst(new int[]{x, y});
                        } else {
                            //否则加入队尾
                            queue.addLast(new int[]{x, y});
                        }
                    }
                }
            }
        }
        return cost[m - 1][n - 1];
    }
}
