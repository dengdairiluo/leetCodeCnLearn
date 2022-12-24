package com.yuren.leetcodecnlearn.Q1200;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-29 23:56
 */
public class Q1182 {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int[][] dp = new int[colors.length][3];
        int lastOnePos = -1, lastTwoPos = -1, lastThreePos = -1;
        for (int i = 0; i < colors.length; i++) {
            switch (colors[i]) {
                case 1: {
                    if (lastOnePos == -1) {
                        lastOnePos = -i;
                    }
                    for (int j = (int) Math.ceil((double) (lastOnePos + i) / 2.0); j <= i; j++) {
                        dp[j][0] = i;
                    }
                    lastOnePos = i;
                    if (i > 0) {
                        dp[i][1] = dp[i - 1][1];
                        dp[i][2] = dp[i - 1][2];
                    }
                    break;
                }
                case 2: {
                    if (lastTwoPos == -1) {
                        lastTwoPos = -i;
                    }
                    for (int j = (int) Math.ceil((double) (lastTwoPos + i) / 2.0); j <= i; j++) {
                        dp[j][1] = i;
                    }
                    lastTwoPos = i;
                    if (i > 0) {
                        dp[i][0] = dp[i - 1][0];
                        dp[i][2] = dp[i - 1][2];
                    }
                    break;
                }
                default: {
                    if (lastThreePos == -1) {
                        lastThreePos = -i;
                    }
                }
                for (int j = (int) Math.ceil((double) (lastThreePos + i) / 2.0); j <= i; j++) {
                    dp[j][2] = i;
                }
                lastThreePos = i;
                if (i > 0) {
                    dp[i][0] = dp[i - 1][0];
                    dp[i][1] = dp[i - 1][1];
                }
                break;
            }
        }
        List<Integer> ret = new ArrayList<>(queries.length);
        for (int[] q : queries) {
            switch (q[1]) {
                case 1:
                    if (lastOnePos != -1) {
                        ret.add(Math.abs(dp[q[0]][0] - q[0]));
                    } else {
                        ret.add(-1);
                    }
                    break;
                case 2:
                    if (lastTwoPos != -1) {
                        ret.add(Math.abs(dp[q[0]][1] - q[0]));
                    } else {
                        ret.add(-1);
                    }
                    break;
                default:
                    if (lastThreePos != -1) {
                        ret.add(Math.abs(dp[q[0]][2] - q[0]));
                    } else {
                        ret.add(-1);
                    }
                    break;
            }
        }
        return ret;
    }
}
