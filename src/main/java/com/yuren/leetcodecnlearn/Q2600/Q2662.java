package com.yuren.leetcodecnlearn.Q2600;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-15 23:56
 */
public class Q2662 {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        long t = (long) target[0] << 32 | target[1];
        Map<Long, Integer> dis = new HashMap<>();
        dis.put(t, Integer.MAX_VALUE);
        dis.put((long) start[0] << 32 | start[1], 0);
        Set<Long> vis = new HashSet<Long>();
        for (;;) {
            long v = -1;
            int dv = -1;
            for (Map.Entry<Long, Integer> e : dis.entrySet())
                if (!vis.contains(e.getKey()) && (dv < 0 || e.getValue() < dv)) {
                    v = e.getKey();
                    dv = e.getValue();
                }
            if (v == t) return dv; // 到终点的最短路已确定
            vis.add(v);
            int vx = (int) (v >> 32), vy = (int) (v & Integer.MAX_VALUE);
            // 更新到终点的最短路
            dis.merge(t, dv + target[0] - vx + target[1] - vy, Math::min);
            for (int[] r : specialRoads) {
                int d = dv + Math.abs(r[0] - vx) + Math.abs(r[1] - vy) + r[4];
                long w = (long) r[2] << 32 | r[3];
                if (d < dis.getOrDefault(w, Integer.MAX_VALUE))
                    dis.put(w, d);
            }
        }
    }
}
