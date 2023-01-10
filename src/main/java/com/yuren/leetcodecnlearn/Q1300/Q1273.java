package com.yuren.leetcodecnlearn.Q1300;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-10 23:53
 */
public class Q1273 {
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        int[] count = new int[nodes];
        Arrays.fill(count, 1);
        int[] degrees = new int[nodes];
        for (int i = 1; i < parent.length; ++i) {
            ++degrees[parent[i]];
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nodes; ++i) {
            if (degrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (value[x] == 0) {
                count[x] = 0;
            }
            int y = parent[x];
            if (y == -1) {
                continue;
            }
            --degrees[y];
            value[y] += value[x];
            count[y] += count[x];
            if (degrees[y] == 0) {
                queue.offer(y);
            }

        }
        return count[0];

    }
}
