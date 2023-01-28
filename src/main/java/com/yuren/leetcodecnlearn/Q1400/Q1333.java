package com.yuren.leetcodecnlearn.Q1400;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-29 00:59
 */
public class Q1333 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            }
            return o2[1] - o1[1];
        }));
        for (int[] r : restaurants) {
            if (r[3] <= maxPrice && r[4] <= maxDistance) {
                // 考虑口味
                if (veganFriendly == 1) {
                    if (r[2] == veganFriendly) {
                        queue.offer(r);
                    }
                } else {
                    queue.offer(r);
                }
            }
        }
        while (!queue.isEmpty()) {
            res.add(queue.poll()[0]);
        }
        return res;
    }
}
