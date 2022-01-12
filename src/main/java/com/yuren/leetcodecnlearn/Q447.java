package com.yuren.leetcodecnlearn;

import java.util.HashMap;
import java.util.Map;

public class Q447 {
    public int numberOfBoomerangs(int[][] points) {
        // 看数据范围只有500，所以，直接枚举每个点，算其他点与它的距离，分组整理
        // 然后统计每个距离有多少个，从其中取两个即可
        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();

        int n = points.length;
        for (int i = 0; i < n; i++) {
            int[] p0 = points[i];
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int[] p1 = points[j];
                    int deltaX = p0[0] - p1[0];
                    int deltaY = p0[1] - p1[1];
                    // distance = (x1-x2)^2 + (y1-y2)^2
                    int distance = deltaX * deltaX + deltaY * deltaY;
                    map.put(distance, map.getOrDefault(distance, 0) + 1);
                }
            }

            // 排列：距离相等的取两个
            for (int val : map.values()) {
                ans += val * (val - 1);
            }

            // 清空map供下一轮使用
            map.clear();
        }

        return ans;
    }
}
