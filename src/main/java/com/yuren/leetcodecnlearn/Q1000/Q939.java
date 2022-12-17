package com.yuren.leetcodecnlearn.Q1000;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-17 23:52
 */
public class Q939 {
    int len = (int) 1e4 * 4 + 1;

    public int minAreaRect(int[][] points) {
        // [[1,1],[1,3],[3,1],[3,3],[2,2]]
        Arrays.sort(points, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int len = points.length;
        int ans = Integer.MAX_VALUE;
        Set<Integer> hash = new HashSet<>();
        for (int i = 0; i < len; i++) {
            int[] p1 = points[i];
            int x1 = p1[0], y1 = p1[1];
            hash.add(x1 * this.len + y1);
        }
        for (int i = 0; i < len; i++) {
            int[] p1 = points[i];
            int x1 = p1[0], y1 = p1[1];
            for (int j = i + 1; j < len; j++) {
                int[] p2 = points[j];
                int x2 = p2[0], y2 = p2[1];
                if (x1 != x2 && y1 != y2 && hash.contains(x1 * this.len + y2) && hash.contains(x2 * this.len + y1)) {
                    ans = Math.min(ans, Math.abs(x2 - x1) * Math.abs(y2 - y1));
                }
            }
        }
//		[[3,2],[3,1],[4,4],[1,1],[4,3],[0,3],[0,2],[4,0]]
        return ans == Integer.MAX_VALUE ? 0 : ans;// 面壁思过
    }
}
