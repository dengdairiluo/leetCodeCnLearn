package com.yuren.leetcodecnlearn.Q1700;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-04 23:46
 */
public class Q1743 {
    public int[] restoreArray(int[][] aps) {
        int m = aps.length, n = m + 1;
        Map<Integer, Integer> cnts = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] ap : aps) {
            int a = ap[0], b = ap[1];
            cnts.put(a, cnts.getOrDefault(a, 0) + 1);
            cnts.put(b, cnts.getOrDefault(b, 0) + 1);
            List<Integer> alist = map.getOrDefault(a, new ArrayList<>());
            alist.add(b);
            map.put(a, alist);
            List<Integer> blist = map.getOrDefault(b, new ArrayList<>());
            blist.add(a);
            map.put(b, blist);
        }
        int start = -1;
        for (int i : cnts.keySet()) {
            if (cnts.get(i) == 1) {
                start = i;
                break;
            }
        }
        int[] ans = new int[n];
        ans[0] = start;
        ans[1] = map.get(start).get(0);
        for (int i = 2; i < n; i++) {
            int x = ans[i - 1];
            List<Integer> list = map.get(x);
            for (int j : list) {
                if (j != ans[i - 2]) ans[i] = j;
            }
        }
        return ans;
    }
}
