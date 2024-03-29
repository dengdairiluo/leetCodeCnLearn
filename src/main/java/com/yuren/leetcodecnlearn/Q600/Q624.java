package com.yuren.leetcodecnlearn.Q600;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-02 23:31
 */
public class Q624 {
    public int maxDistance(List<List<Integer>> arrays) {
        List<Integer> first = arrays.get(0);
        int min = first.get(0);
        int fSize = first.size();
        int max = first.get(fSize - 1);
        int n = arrays.size();
        int res = 0;
        for (int i = 1; i < n; ++i) {
            List<Integer> item = arrays.get(i);
            int m = item.size();
            int crrMin = item.get(0);
            int crrMax = item.get(m - 1);
            res = getMax(crrMax - min, res, max - crrMin);
            max = Math.max(crrMax, max);
            min = Math.min(crrMin, min);
        }
        return res;
    }

    private int getMax(int a, int b, int c) {
        int res = a;
        res = Math.max(res, b);
        res = Math.max(res, c);
        return res;
    }
}
