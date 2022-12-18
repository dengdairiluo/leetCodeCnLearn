package com.yuren.leetcodecnlearn.Q1100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-28 00:14
 */
public class Q1036 {
    private static final int BOUND = (int) 1e6;
    private static final long HASH_BOUND = (long) 1e6;
    private static final int[][] dir = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    private Set<Long> block;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        int max = blocked.length * (blocked.length - 1) / 2;
        block = new HashSet<>();
        for (int[] p : blocked) {
            block.add(p[0] * HASH_BOUND + p[1]);
        }
        return bfs(source, target, max) && bfs(target, source, max);
    }

    private boolean bfs(int[] start, int[] end, int max) {
        List<int[]> list = new ArrayList<int[]>() {{
            add(start);
        }};
        Set<Long> explored = new HashSet<Long>() {{
            add(start[0] * HASH_BOUND + start[1]);
        }};
        for (int i = 0; i < list.size() && list.size() <= max; i++) {
            for (int[] ints : dir) {
                int[] point = new int[]{list.get(i)[0] + ints[0], list.get(i)[1] + ints[1]};
                long p = point[0] * HASH_BOUND + point[1];
                if (point[0] >= 0 && point[0] < BOUND && point[1] >= 0 && point[1] < BOUND && !explored.contains(p) && !block.contains(p)) {
                    if (point[0] == end[0] && point[1] == end[1]) {
                        return true;
                    }
                    explored.add(p);
                    list.add(point);
                }
            }
        }
        return list.size() > max;
    }
}
