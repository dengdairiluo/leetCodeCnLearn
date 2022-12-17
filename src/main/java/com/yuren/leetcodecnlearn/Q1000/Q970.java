package com.yuren.leetcodecnlearn.Q1000;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-30 23:50
 */
public class Q970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> ans = new HashSet<>();
        int m = x == 1 ? 0 : (int) (Math.log10(bound) / Math.log10(x));
        int n = y == 1 ? 0 : (int) (Math.log10(bound) / Math.log10(y));
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int cur = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                if (cur <= bound) {
                    ans.add(cur);
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
