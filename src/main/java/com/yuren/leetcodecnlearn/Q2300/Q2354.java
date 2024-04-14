package com.yuren.leetcodecnlearn.Q2300;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-14 下午10:17
 */
public class Q2354 {
    static final int U = 30;

    public long countExcellentPairs(int[] nums, int k) {
        Set<Integer> vis = new HashSet<>();
        int[] cnt = new int[U];
        for (int x : nums)
            if (vis.add(x)) ++cnt[Integer.bitCount(x)];
        long ans = 0L;
        int s = 0;
        for (int i = k; i < U; ++i)
            s += cnt[i];
        for (int cx = 0; cx < U; ++cx) {
            ans += (long) cnt[cx] * s;
            int cy = k - 1 - cx;
            if (0 <= cy && cy < U) s += cnt[cy];
        }
        return ans;
    }
}
