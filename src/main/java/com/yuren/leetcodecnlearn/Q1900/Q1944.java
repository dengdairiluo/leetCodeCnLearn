package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-21 23:33
 */
public class Q1944 {
    public int[] canSeePersonsCount(int[] heights) {
        int[] seeCounts = new int[heights.length];
        int[] heightStack = new int[heights.length];
        int top = -1;
        for (int i = heights.length - 1; i >= 0; i--) {
            int height = heights[i];
            int seeCount = 0;
            for (; top >= 0 && height >= heightStack[top]; top--) {
                seeCount++;
            }
            if (top >= 0) {
                seeCount++;
            }
            heightStack[++top] = height;
            seeCounts[i] = seeCount;
        }
        return seeCounts;
    }
}
