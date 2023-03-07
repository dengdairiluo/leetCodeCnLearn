package com.yuren.leetcodecnlearn.Q900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-25 23:42
 */
public class Q960 {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        if (rows == 0)
            return 0;
        int cols = strs[0].length();
        char[][] chars = new char[rows][cols];
        for (int i = 0; i < rows; ++i)
            chars[i] = strs[i].toCharArray();
        int[] dp = new int[cols];
        int max = 1;
        for (int i = 0; i < cols; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                boolean flag = true;
                for (int r = 0; r < rows; ++r) {
                    if (chars[r][i] < chars[r][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return cols - max;
    }
}
