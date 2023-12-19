package com.yuren.leetcodecnlearn.Q2100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-19 23:11
 */
public class Q2123 {
    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    int[][] grid;
    int m, n;

    Map<Integer, Integer> map;

    public int minimumOperations(int[][] grid) {

        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        map = new HashMap<>(m * n);
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if ((i + j) % 2 == 0 && grid[i][j] == 1) {
                    int id = i * n + j;
                    for (int[] d : directions) {
                        int x = i + d[0], y = j + d[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                            Set<Integer> set = new HashSet<>();
                            int nid = x * n + y;
                            set.add(nid);
                            if (!map.containsKey(nid) || find(map.get(nid), set)) {
                                map.put(nid, id);
                                result++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    boolean find(int id, Set<Integer> set) {
        int x = id / n, y = id % n;

        for (int[] d : directions) {
            int nx = x + d[0], ny = y + d[1];
            int nid = nx * n + ny;

            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1 && !set.contains(nid)) {

                set.add(nid);

                if (!map.containsKey(nid) || find(map.get(nid), set)) {
                    map.put(nid, id);
                    return true;
                }

                set.remove(nid);
            }
        }
        return false;

    }
}
