package com.yuren.leetcodecnlearn.Q1300;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-25 02:07
 */
public class Q1229 {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        for (int[] slot : slots1) {
            if (slot[1] - slot[0] >= duration) {
                heap.offer(slot);
            }
        }

        for (int[] slot : slots2) {
            if (slot[1] - slot[0] >= duration) {
                heap.offer(slot);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (heap.size() >= 2) {
            int[] slot1 = heap.poll();
            int[] slot2 = heap.peek();

            if (slot2[0] <= slot1[1] - duration) {
                ans.add(slot2[0]);
                ans.add(slot2[0] + duration);
                return ans;
            }
        }
        return ans;
    }
}
