package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-21 23:36
 */
public class Q1620 {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int[] ans = new int[2];
        double max = 0;
        int re2 = radius * radius;

        // 寻找到能覆盖到所有塔的矩形范围
        int minx = Integer.MAX_VALUE;
        int miny = Integer.MAX_VALUE;
        int maxx = 0;
        int maxy = 0;
        for (int[] ints : towers) {
            minx = Math.min(ints[0], minx);
            miny = Math.min(ints[1], miny);
            maxx = Math.max(ints[0], maxx);
            maxy = Math.max(ints[1], maxy);
        }

        // 遍历这个范围内的每一个点
        for (int i = minx; i <= maxx; i++) {
            for (int j = miny; j <= maxy; j++) {
                int power = 0;
                // 遍历每一个塔获取到当前点的信号强度
                for (int[] tower : towers) {
                    int dis = (tower[0] - i) * (tower[0] - i) + (tower[1] - j) * (tower[1] - j);
                    if (dis <= re2) {
                        power += tower[2] / (1 + Math.sqrt(dis));
                    }
                }
                // 更新结果
                if (power > max) {
                    max = power;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }
}
