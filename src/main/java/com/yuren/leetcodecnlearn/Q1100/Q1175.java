package com.yuren.leetcodecnlearn.Q1100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-26 23:46
 */
public class Q1175 {
    private static final int MOD = (int) 1e9 + 7;
    static int[] cnts = new int[110];

    static {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= 100; i++) {
            boolean ok = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                list.add(i);
            }
            cnts[i] = list.size();
        }
    }

    public int numPrimeArrangements(int n) {
        int a = cnts[n], b = n - a;
        long ans = 1;
        for (int i = b; i > 1; i--) ans = ans * i % MOD;
        for (int i = a; i > 1; i--) ans = ans * i % MOD;
        return (int) ans;
    }
}
