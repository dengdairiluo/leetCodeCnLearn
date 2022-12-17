package com.yuren.leetcodecnlearn.Q900;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-16 10:08
 */
public class Q862 {
    public int shortestSubarray(int[] a, int k) {
        int n = a.length;
        long[] p = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            p[i + 1] = p[i] + (long) a[i];
        }

        // Want smallest y-x with P[y] - P[x] >= K
        // N+1 is impossible
        int ans = n + 1;
        //opt(y) candidates, as indices of P
        Deque<Integer> monoq = new LinkedList<>();

        for (int y = 0; y < p.length; ++y) {
            // Want opt(y) = largest x with P[x] <= P[y] - K;
            if (!monoq.isEmpty() && p[y] <= p[monoq.getLast()]) {
                do {
                    monoq.removeLast();
                }
                while (!monoq.isEmpty() && p[y] <= p[monoq.getLast()]);
            }
            while (!monoq.isEmpty() && p[y] >= p[monoq.getFirst()] + k) {
                ans = Math.min(ans, y - monoq.removeFirst());
            }

            monoq.addLast(y);
        }

        return ans < n + 1 ? ans : -1;
    }
}
