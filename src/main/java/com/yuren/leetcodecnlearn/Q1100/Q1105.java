package com.yuren.leetcodecnlearn.Q1100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-26 23:43
 */
public class Q1105 {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        //dp[i]表示以第i-1本书（从第0本算起）结尾的前i本书叠成的最小高度
        int[] dp = new int[n + 1];

        dp[1] = books[0][1];

        for (int i = 2; i <= n; i++) {
            dp[i] = books[i - 1][1] + dp[i - 1];
            int w = books[i - 1][0], h = books[i - 1][1];
            for (int j = i - 1; j > 0; j--) {
                w += books[j - 1][0];
                if (w > shelfWidth) {
                    break;
                }
                h = Math.max(h, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + h);
            }
        }

        return dp[n];
    }
}
