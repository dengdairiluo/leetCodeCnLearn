package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-14 23:04
 */
public class Q2237 {
    public int meetRequirement(int n, int[][] lights, int[] requirement) {
        int[] delta = new int[n];
        for (int[] light : lights) {
            ++delta[Math.max(0, light[0] - light[1])];
            if (light[0] + light[1] + 1 < n) --delta[light[0] + light[1] + 1];
        }
        int x = 0;
        int result = 0;
        for (int i = 0; i < n; ++i) {
            x += delta[i];
            if (x >= requirement[i]) ++result;
        }
        return result;
    }
}
