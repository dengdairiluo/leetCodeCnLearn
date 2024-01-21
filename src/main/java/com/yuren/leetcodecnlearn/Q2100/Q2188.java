package com.yuren.leetcodecnlearn.Q2100;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-21 23:52
 */
public class Q2188 {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        int[] cnt = new int[18];
        Arrays.fill(cnt, Integer.MAX_VALUE / 2);
        for (int[] tire : tires) {
            int time = tire[0];
            int sum = 0;
            for (int i = 1; i < 18 && time <= tire[0] + changeTime; i++) {
                sum += time;
                cnt[i] = Math.min(cnt[i], sum);
                time *= tire[1];
            }
        }
        // System.out.println(Arrays.toString(cnt));
        int[] f = new int[numLaps + 1];
        Arrays.fill(f, Integer.MAX_VALUE / 2);
        f[0] = -changeTime;
        for (int i = 1; i <= numLaps; i++) {
            for (int j = 1; j < 18 && j <= i; j++) {
                f[i] = Math.min(f[i], f[i - j] + cnt[j]);
            }
            f[i] += changeTime;
        }
        return f[numLaps];
    }
}
