package com.yuren.leetcodecnlearn.Q1300;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-23 23:45
 */
public class Q1320 {
    public int minimumDistance(String word) {
        // 初始化
        int len = word.length();
        int ans = Integer.MAX_VALUE;
        char[] ca = word.toCharArray();
        // 第一个字母的初始值为 0，从第二个字母开始考虑。
        int[][] dp = new int[2][26];
        Arrays.fill(dp[1], Integer.MAX_VALUE);

        // 遍历每个字母
        for (int i = 2; i <= word.length(); i++) {
            int v = ca[i - 1] - 'A';
            // 遍历上一个阶段键位
            for (int j = 0; j < 26; j++) {
                if (dp[i % 2][j] == Integer.MAX_VALUE) {
                    continue;
                }
                int preV = ca[i - 2] - 'A';
                dp[(i + 1) % 2][j] = Math.min(dp[(i + 1) % 2][j], dp[i % 2][j] + help(preV, v));
                dp[(i + 1) % 2][preV] = Math.min(dp[(i + 1) % 2][preV], dp[i % 2][j] + help(j, v));
                if (i == word.length()) {
                    ans = Math.min(ans, dp[(i + 1) % 2][j]);
                    ans = Math.min(ans, dp[(i + 1) % 2][preV]);
                }
            }
            Arrays.fill(dp[i % 2], Integer.MAX_VALUE);
        }
        return ans;
    }

    // 计算距离
    public int help(int a, int b) {
        int x = a / 6, y = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return (int) (Math.abs(x - x2)) + (int) (Math.abs(y - y2));
    }
}
