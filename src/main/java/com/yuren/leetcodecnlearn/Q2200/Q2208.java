package com.yuren.leetcodecnlearn.Q2200;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-31 23:51
 */
public class Q2208 {
    public int halveArray(int[] nums) {
        double s = 0;
        PriorityQueue<Double> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int v : nums) {
            q.offer(v * 1.0);
            s += v;
        }
        s /= 2.0;
        int ans = 0;
        while (s > 0) {
            double t = q.poll();
            s -= t / 2.0;
            q.offer(t / 2.0);
            ++ans;
        }
        return ans;
    }
}
