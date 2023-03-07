package com.yuren.leetcodecnlearn.Q1000;

import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-04 23:36
 */
public class Q1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] counts = new int[10001], res = new int[barcodes.length];
        for (int barcode : barcodes) {
            counts[barcode]++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> counts[o2] - counts[o1]);
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                queue.offer(i);
            }
        }
        int id = 0;
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            res[id++] = a;
            res[id++] = b;
            if (counts[a] > 1) {
                counts[a]--;
                queue.offer(a);
            }
            if (counts[b] > 1) {
                counts[b]--;
                queue.offer(b);
            }
        }
        if (!queue.isEmpty()) {
            res[id] = queue.poll();
        }
        return res;
    }
}
