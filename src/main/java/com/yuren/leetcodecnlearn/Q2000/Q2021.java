package com.yuren.leetcodecnlearn.Q2000;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-30 00:01
 */
public class Q2021 {
    public int brightestPosition(int[][] lights) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int[] x : lights) {
            int left = x[0] - x[1];
            // 因为两侧都包含，所以+1
            int right = x[0] + x[1] + 1;
            tm.put(left, tm.getOrDefault(left, 0) + 1);
            tm.put(right, tm.getOrDefault(right, 0) - 1);
        }
        int ans = Integer.MIN_VALUE;
        // 最大的亮度
        int max = 0;
        // 当前的亮度
        int cur = 0;
        for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            cur += entry.getValue();
            if (cur > max) {
                max = cur;
                ans = entry.getKey();
            }
        }
        return ans;
    }
}
