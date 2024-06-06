package com.yuren.leetcodecnlearn.Q2400;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-06 下午11:12
 */
public class Q2462 {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long ans = 0;
        if (candidates * 2 >= n) {
            Arrays.sort(costs);
            for (int i = 0; i < k; ++i) {
                ans += costs[i];
            }
            return ans;
        }
        PriorityQueue<int[]> pq
                = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < candidates; ++i) {
            pq.offer(new int[]{costs[i], i});
            pq.offer(new int[]{costs[n - i - 1], n - i - 1});
        }
        int l = candidates, r = n - candidates - 1;
        while (k-- > 0) {
            int[] p = pq.poll();
            ans += p[0];
            if (l > r) {
                continue;
            }
            if (p[1] < l) {
                pq.offer(new int[]{costs[l], l++});
            } else {
                pq.offer(new int[]{costs[r], r--});
            }
        }
        return ans;
    }
}
