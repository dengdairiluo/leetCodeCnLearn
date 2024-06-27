package com.yuren.leetcodecnlearn.Q2500;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-28 上午12:08
 */
public class Q2503 {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    Deque<int[]>[] de;


    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length;
        int k = queries.length;

        Integer[] pos = new Integer[k];
        for (int i = 0; i < k; i++)
            pos[i] = i;

        Arrays.sort(pos, Comparator.comparingInt(x -> queries[x]));
        de = new Deque[k];
        Arrays.setAll(de, x -> new ArrayDeque<>());

        de[0].offer(new int[]{0, 0, grid[0][0]});
        grid[0][0] = 0;

        int[] ans = new int[k];
        int count = 0;
        for (int i = 0; i < k; i++) {
            int query = queries[pos[i]];
            Deque<int[]> q = de[i];
            while (!q.isEmpty()) {

                int[] curr = q.poll();
                int x = curr[0], y = curr[1], val = curr[2];
                if (val < query) {
                    ++count;
                    for (int[] d : directions) {
                        int nx = x + d[0];
                        int ny = y + d[1];

                        if (nx < 0 || nx == m || ny < 0 || ny == n || grid[nx][ny] == 0)
                            continue;

                        q.offer(new int[]{nx, ny, grid[nx][ny]});
                        grid[nx][ny] = 0;
                    }
                } else {
                    int p = binary(queries, pos, i + 1, k - 1, val);
                    if (p < k)
                        de[p].offer(curr);
                }
            }
            ans[pos[i]] = count;
        }
        return ans;
    }

    private int binary(int[] queries, Integer[] pos, int l, int r, int target) {
        while (l <= r) {
            int m = (l + r) >> 1;
            if (queries[pos[m]] > target)
                r = m - 1;
            else
                l = m + 1;
        }
        return l;
    }

}
