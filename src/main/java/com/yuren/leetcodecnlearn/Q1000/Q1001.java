package com.yuren.leetcodecnlearn.Q1000;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-13 23:48
 */
public class Q1001 {
    /**
     * 方位数组
     */
    private static final int[][] dirs = new int[][]{
            {0, 0},     // 当前位置
            {0, 1},     // 上   ↑
            {0, -1},    // 下   ↓
            {-1, 0},    // 左   ←
            {1, 0},     // 右   →
            {-1, 1},    // 左上 ↖
            {-1, -1},   // 左下 ↙
            {1, 1},     // 右上 ↗
            {1, -1}     // 右下 ↘
    };

    void increment(Map<Integer, Integer> map, int key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    void decrement(Map<Integer, Integer> map, int key) {
        if (map.get(key) == 1) {
            map.remove(key);
        } else {
            map.put(key, map.get(key) - 1);
        }
    }

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        long N = n;

        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        Set<Long> hashSet = new HashSet<>();

        for (int[] lamp : lamps) {
            int x = lamp[0];
            int y = lamp[1];
            int a = x + y;
            int b = x - y;

            if (hashSet.contains(x * N + y)) {
                continue;
            }

            increment(row, x);
            increment(col, y);
            increment(left, a);
            increment(right, b);

            hashSet.add(x * N + y);
        }

        int qLen = queries.length;
        int[] ans = new int[qLen];

        for (int i = 0; i < qLen; i++) {
            int[] q = queries[i];
            int x = q[0], y = q[1];
            int a = x + y, b = x - y;

            if (!row.containsKey(x) && !col.containsKey(y) && !left.containsKey(a) && !right.containsKey(b)) {
                continue;
            }
            ans[i] = 1;

            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                int na = nx + ny;
                int nb = nx - ny;

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if (hashSet.contains(nx * N + ny)) {

                    hashSet.remove(nx * N + ny);

                    decrement(row, nx);
                    decrement(col, ny);
                    decrement(left, na);
                    decrement(right, nb);
                }
            }
        }

        return ans;

    }
}
