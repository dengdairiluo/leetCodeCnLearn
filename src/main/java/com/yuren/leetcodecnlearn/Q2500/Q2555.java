package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-23 下午11:49
 */
public class Q2555 {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        if (n == 1) {
            return 1;
        }
        int[] leftMax = new int[n];
        int start = 0, end = 0;
        while (end < n) {
            while (prizePositions[end] - prizePositions[start] > k) {
                start++;
            }
            leftMax[end] = end - start + 1;
            if (end > 0) {
                leftMax[end] = Math.max(leftMax[end], leftMax[end - 1]);
            }
            end++;
        }
        int maxWin = 0;
        start = n - 1;
        end = n - 1;
        while (start > 0) {
            while (prizePositions[end] - prizePositions[start] > k) {
                end--;
            }
            int right = end - start + 1;
            maxWin = Math.max(maxWin, leftMax[start - 1] + right);
            start--;
        }
        return maxWin;
    }
}

