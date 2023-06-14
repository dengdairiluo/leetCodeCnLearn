package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-14 23:45
 */
public class Q1687 {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length, cnt = 2, left = 0, w = boxes[0][1];
        int[] dp = new int[n + 1];
        dp[1] = 2;
        for (int i = 1; i < n; i++) {
            if (boxes[i - 1][0] != boxes[i][0]) {
                cnt++;
            }
            w += boxes[i][1];
            while (w > maxWeight || i - left + 1 > maxBoxes || dp[left] == dp[left + 1]) {
                w -= boxes[left++][1];
                if (boxes[left - 1][0] != boxes[left][0]) {
                    cnt--;
                }
            }
            dp[i + 1] = dp[left] + cnt;
        }
        return dp[n];
    }
}
