package com.yuren.leetcodecnlearn.Q700;

import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-17 23:32
 */
public class Q659 {
    public boolean isPossible(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int num : nums) {
            if (!pq.isEmpty() && pq.peek()[0] != num) {
                while (!pq.isEmpty() && pq.peek()[0] != num - 1) {
                    if (pq.peek()[1] >= 3) {
                        pq.poll();
                    } else {
                        return false;
                    }
                }
                if (!pq.isEmpty()) {
                    int[] cur = pq.poll();
                    pq.add(new int[]{num, cur[1] + 1});
                } else {
                    pq.add(new int[]{num, 1});
                }
            } else {
                pq.add(new int[]{num, 1});
            }
        }
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[1] < 3) {
                return false;
            }
        }
        return true;
    }
}
