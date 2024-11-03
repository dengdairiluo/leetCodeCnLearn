package com.yuren.leetcodecnlearn.Q2700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-11-03 22:57
 */
public class Q2761 {
    private final static int MX = (int) 1e6;
    private final static int[] primes = new int[78498];
    private final static boolean[] np = new boolean[MX + 1];

    static {
        int pi = 0;
        for (int i = 2; i <= MX; ++i) {
            if (!np[i]) {
                primes[pi++] = i;
                // 避免溢出的写法
                for (int j = i; j <= MX / i; ++j)
                    np[i * j] = true;
            }
        }
    }

    public List<List<Integer>> findPrimePairs(int n) {
        if (n % 2 > 0)
            return n > 4 && !np[n - 2] ? Collections.singletonList(Arrays.asList(2, n - 2)) : Collections.emptyList();
        List<List<Integer>> ans = new ArrayList<>();
        for (int x : primes) {
            int y = n - x;
            if (y < x) break;
            if (!np[y]) ans.add(Arrays.asList(x, y));
        }
        return ans;
    }
}
