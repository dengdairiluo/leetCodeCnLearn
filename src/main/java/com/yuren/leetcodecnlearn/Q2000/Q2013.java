package com.yuren.leetcodecnlearn.Q2000;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-25 23:25
 */
public class Q2013 {
    Map<Integer, Map<Integer, Integer>> row2Col = new HashMap<>();

    public void add(int[] point) {
        int x = point[0], y = point[1];
        Map<Integer, Integer> col2Cnt = row2Col.getOrDefault(x, new HashMap<>());
        col2Cnt.put(y, col2Cnt.getOrDefault(y, 0) + 1);
        row2Col.put(x, col2Cnt);
    }

    public int count(int[] point) {
        int x = point[0], y = point[1];
        int ans = 0;
        Map<Integer, Integer> col2Cnt = row2Col.getOrDefault(x, new HashMap<>());
        for (int ny : col2Cnt.keySet()) {
            if (ny == y) continue;
            int c1 = col2Cnt.get(ny);
            int len = y - ny;
            int[] nums = new int[]{x + len, x - len};
            for (int nx : nums) {
                Map<Integer, Integer> temp = row2Col.getOrDefault(nx, new HashMap<>());
                int c2 = temp.getOrDefault(y, 0), c3 = temp.getOrDefault(ny, 0);
                ans += c1 * c2 * c3;
            }
        }
        return ans;
    }
}
