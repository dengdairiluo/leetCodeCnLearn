package com.yuren.leetcodecnlearn.Q900;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-07 22:33
 */
public class Q909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] vis = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 1; i <= 6; ++i) {
                int nxt = p[0] + i;
                // 超出边界
                if (nxt > n * n) {
                    break;
                }
                // 得到下一步的行列
                int[] rc = id2rc(nxt, n);
                // 存在蛇或梯子
                if (board[rc[0]][rc[1]] > 0) {
                    nxt = board[rc[0]][rc[1]];
                }
                // 到达终点
                if (nxt == n * n) {
                    return p[1] + 1;
                }
                if (!vis[nxt]) {
                    vis[nxt] = true;
                    // 扩展新状态
                    queue.offer(new int[]{nxt, p[1] + 1});
                }
            }
        }
        return -1;
    }

    public int[] id2rc(int id, int n) {
        int r = (id - 1) / n, c = (id - 1) % n;
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        return new int[]{n - 1 - r, c};
    }
}
