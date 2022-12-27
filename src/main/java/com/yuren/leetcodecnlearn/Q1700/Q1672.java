package com.yuren.leetcodecnlearn.Q1700;

public class Q1672 {
    public int maximumWealth(int[][] accounts) {

        int maxSum = -1;
        int sum = -1;
        for (int i = 0; i < accounts.length; i++) {
            sum = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                sum += accounts[i][j];
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
