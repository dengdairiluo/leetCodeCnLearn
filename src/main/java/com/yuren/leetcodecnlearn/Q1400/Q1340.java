package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-01 00:33
 */
public class Q1340 {
    int[] arr;
    //数组长度
    int d;
    int n;
    //用来存储每个柱子的最大结果
    int[] dp;

    public int maxJumps(int[] arr, int d) {
        this.arr = arr;
        this.n = arr.length;
        this.d = d;
        dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, getMaxFromOnePoint(i));
        }
        return ans;
    }

    private int getMaxFromOnePoint(int p) {
        //当前柱子已经计算过，直接返回它的值
        if (dp[p] != 0) {
            return dp[p];
        }
        // 如果没有，分别计算它往左和往右跳一次可以得到的最大值
        int leftMax = 0;
        // 往左跳的距离
        int l = 1;
        while (p - l >= 0 && l <= d) {
            //遇到了高柱子挡路，只能结束
            if (arr[p - l] >= arr[p]) {
                break;
            } else {
                if (dp[p - l] == 0) {
                    dp[p - l] = getMaxFromOnePoint(p - l);
                }
                leftMax = Math.max(leftMax, dp[p - l]);
                l++;
            }
        }
        // 同理右边
        int rightMax = 0;
        int r = 1;
        while (p + r < n && r <= d) {
            if (arr[p + r] >= arr[p]) {
                break;
            } else {
                if (dp[p + r] == 0) {
                    dp[p + r] = getMaxFromOnePoint(p + r);
                }
                rightMax = Math.max(rightMax, dp[p + r]);
                r++;
            }
        }
        dp[p] = Math.max(leftMax, rightMax) + 1;
        return dp[p];
    }
}
