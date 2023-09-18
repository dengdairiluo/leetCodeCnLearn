package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-18 23:27
 */
public class Q1936 {
    public static int addRungs(int[] rungs, int dist) {
        int ans = 0;
        int step = 0;
        for (int rung : rungs) {
            if (step + dist < rung) {
                int diff = rung - 1 - step;
                int count = diff / dist;
                ans += count;
            }
            step = rung;
        }
        return ans;
    }
}
