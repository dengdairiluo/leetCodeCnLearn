package com.yuren.leetcodecnlearn.Q800;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-16 10:13
 */
public class Q864 {
    private static class Node {
        int x, y;
        int len;
        int key;

        Node(int x, int y, int key, int len) {
            this.x = x;
            this.y = y;
            this.key = key;
            this.len = len;
        }
    }

    public int shortestPathAllKeys(String[] grid) {
        int row = grid.length;
        int col = grid[0].length();
        int keys = 0;
        //右下左上
        int[] dx = new int[]{
                0, 1, 0, -1
        };
        int[] dy = new int[]{
                1, 0, -1, 0
        };
        boolean[][][] visited = new boolean[row][col][64];
        Deque<Node> q = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            String r = grid[i];
            for (int j = 0; j < col; j++) {
                char c = r.charAt(j);
                if (c == '@') {
                    q.offerLast(new Node(i, j, 0, 0));
                    visited[i][j][0] = true;
                }
                if (c <= 'f' && c >= 'a') {
                    keys |= (1 << (c - 'a'));
                }
            }
        }
        while (!q.isEmpty()) {
            Node head = q.pollFirst();
            int tmpX = head.x;
            int tmpY = head.y;
            int key = head.key;

            for (int i = 0; i < 4; i++) {
                int x = tmpX + dx[i];
                int y = tmpY + dy[i];

                if (!check(x, y, grid)) {
                    continue;
                }
                if (visited[x][y][key]) {
                    continue;
                }

                char c = grid[x].charAt(y);
                if (c <= 'F' && c >= 'A') {
                    if ((key & (1 << (c - 'A'))) == 0) {
                        continue;
                    }
                }
                int tmp = key;
                if (c <= 'f' && c >= 'a') {
                    tmp |= 1 << (c - 'a');
                }
                if (tmp == keys) {
                    return head.len + 1;
                }
                visited[x][y][tmp] = true;
                q.offerLast(new Node(x, y, tmp, head.len + 1));


            }
        }
        return -1;
    }

    public boolean check(int x, int y, String[] grid) {
        if (x < 0 || x >= grid.length) {
            return false;
        }
        if (y < 0 || y >= grid[0].length()) {
            return false;
        }
        if (grid[x].charAt(y) == '#') {
            return false;
        }
        return true;
    }
}
