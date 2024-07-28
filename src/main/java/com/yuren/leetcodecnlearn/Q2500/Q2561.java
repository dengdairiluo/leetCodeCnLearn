package com.yuren.leetcodecnlearn.Q2500;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-28 下午8:07
 */
public class Q2561 {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < basket1.length; ++i) {
            cnt.merge(basket1[i], 1, Integer::sum);
            cnt.merge(basket2[i], -1, Integer::sum);
        }

        int mn = Integer.MAX_VALUE;
        List<Integer> a = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            int x = e.getKey(), c = e.getValue();
            if (c % 2 != 0) return -1;
            mn = Math.min(mn, x);
            for (c = Math.abs(c) / 2; c > 0; --c)
                a.add(x);
        }

        long ans = 0;
        a.sort(Comparator.comparingInt(x -> x)); // 也可以用快速选择
        for (int i = 0; i < a.size() / 2; ++i)
            ans += Math.min(a.get(i), mn * 2);
        return ans;
    }
}
