package com.yuren.leetcodecnlearn.Q1300;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-29 23:28
 */
public class Q1335 {
    static final int MAX = 10010;

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        // leftMax[i] 表示前面的 job 中难度大于等于 job_i 的 job 的 index
        int[] leftMax = new int[n];
        Arrays.fill(leftMax, -1);
        Stack<Integer> stack = new Stack<Integer>() {{
            push(0);
        }};
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && jobDifficulty[i] > jobDifficulty[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                leftMax[i] = stack.peek();
            }
            stack.push(i);
        }
        // dp[i][day]: 前 i 个 job 在 day 天内完成的最小结果，初始化为 MAX 值
        int[][] dp = new int[n][d + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], MAX);
        }
        // dp[0][0] = 0; wrong
        // 在第 1 天完成第 0 个 job 的最小结果
        dp[0][1] = jobDifficulty[0];
        // 从第 1 个 job 开始遍历所有工作
        for (int i = 1; i < n; i++) {
            // 前面最近的难度更大的 job
            int j = leftMax[i];
            // 从第 1 天开始遍历所有天数
            for (int day = 1; day <= Math.min(i + 1, d); day++) {

                // （1）job_i 在 第 day 天完成，但没有成为最大难度, 那么 i 前面必须存在更大难度
                if (j != -1) {
                    dp[i][day] = Math.min(dp[i][day], dp[j][day]);
                }
                // 如果 job_i 前不存在难度更大的 job，并且 day 为第 1 天
                else if (day == 1) {
                    dp[i][day] = Math.min(dp[i][day], jobDifficulty[i]);
                }

                // （2）job_i 在第 day 天完成，并成为最大难度（job_i 前面可存在/不存在难度更大的job）
                if (day > 1) {
                    // 如果 job_i 前存在难度更大的 job_j，那么 job_i 要成为 day 的最大难度的工作，job_j 和 job_i 必须分开在两天完成
                    // 如果 job_i 前不存在难度更大的 job_j，那么前面所有的 job 均可与 job_i 分开为两天完成
                    j = Math.max(0, j);
                    for (int k = j; k < i; k++) {
                        dp[i][day] = Math.min(dp[i][day], dp[k][day - 1] + jobDifficulty[i]);
                    }
                }
            }
        }
        return dp[n - 1][d] >= MAX ? -1 : dp[n - 1][d];
    }
}
