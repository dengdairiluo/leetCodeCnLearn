package com.yuren.leetcodecnlearn.Q1700;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-22 23:36
 */
public class Q1713 {
    public int minOperations(int[] target, int[] arr) {
        int n = target.length, m = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(target[i], i);
        }
        List<Integer> list = new ArrayList<>();
        for (int j : arr) {
            if (map.containsKey(j)) {
                list.add(map.get(j));
            }
        }
        int len = list.size(), max = 0;
        int[] f = new int[len + 1], g = new int[len + 1];
        Arrays.fill(g, Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            int t = list.get(i);
            int l = 0, r = len;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (g[mid] < t) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            int clen = r + 1;
            f[i] = clen;
            g[clen] = Math.min(g[clen], t);
            max = Math.max(max, f[i]);
        }
        return n - max;
    }
}
