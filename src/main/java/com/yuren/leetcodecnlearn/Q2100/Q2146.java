package com.yuren.leetcodecnlearn.Q2100;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-31 19:19
 */
public class Q2146 {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {

        int m = grid.length;
        int n = grid[0].length;

        List<List<Integer>> ans = new ArrayList<>();

        int[] dirct = new int[]{-1, 0, 1, 0, -1};

        Deque<int[]> deque = new LinkedList<>();
        deque.add(start);
        int x = start[0], y = start[1];
        int cost = grid[x][y];
        if (cost >= pricing[0] && cost <= pricing[1]) {
            List<Integer> a = new ArrayList<>();
            a.add(x);
            a.add(y);
            ans.add(a);
            if (ans.size() >= k) {
                return ans;
            }
        }
        grid[x][y] = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<int[]> tmp = new ArrayList<>();
            while (size-- > 0) {
                int[] curr = deque.poll();
                x = curr[0];
                y = curr[1];
                for (int i = 0; i < 4; i++) {
                    int nx = x + dirct[i];
                    int ny = y + dirct[i + 1];

                    if (nx < 0 || nx == m || ny < 0 || ny == n || grid[nx][ny] == 0) {
                        continue;
                    }
                    cost = grid[nx][ny];
                    if (cost >= pricing[0] && cost <= pricing[1]) {
                        tmp.add(new int[]{nx, ny, cost});
                    }
                    deque.add(new int[]{nx, ny});
                    grid[nx][ny] = 0;
                }
            }
            tmp.sort((a, b) -> a[2] == b[2] ? (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]) : a[2] - b[2]);
            for (int[] t : tmp) {
                List<Integer> a = new ArrayList<>();
                a.add(t[0]);
                a.add(t[1]);
                ans.add(a);
                if (ans.size() >= k) {
                    return ans;
                }
            }

        }
        return ans;
    }
}
