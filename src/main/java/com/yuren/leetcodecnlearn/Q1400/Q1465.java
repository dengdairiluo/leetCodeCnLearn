package com.yuren.leetcodecnlearn.Q1400;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-20 00:01
 */
public class Q1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long horizonMax = 0, verticalMax = 0;
        int mod = 1000000007;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        for (int i = 1; i < horizontalCuts.length; i++) {
            horizonMax = Math.max(horizonMax, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        // 补充验证边界切割位置
        horizonMax = Math.max(horizonMax, horizontalCuts[0]);
        horizonMax = Math.max(horizonMax, h - horizontalCuts[horizontalCuts.length - 1]);

        for (int i = 1; i < verticalCuts.length; i++) {
            verticalMax = Math.max(verticalMax, verticalCuts[i] - verticalCuts[i - 1]);
        }
        // 补充验证边界切割位置
        verticalMax = Math.max(verticalMax, verticalCuts[0]);
        verticalMax = Math.max(verticalMax, w - verticalCuts[verticalCuts.length - 1]);

        return (int) ((horizonMax * verticalMax) % mod);
    }
}
