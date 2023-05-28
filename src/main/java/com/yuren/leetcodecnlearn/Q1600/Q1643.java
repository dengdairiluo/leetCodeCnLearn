package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-28 23:51
 */
public class Q1643 {
    public String kthSmallestPath(int[] destination, int k) {
        int rows = destination[0];
        //字符"H"的数量
        int h = destination[1];
        //字符"V"的数量
        int v = rows;
        StringBuilder sb = new StringBuilder();
        //动态规划求解组合数量，乘法容易溢出
        int[][] dp = new int[h + v][h];
        dp[0][0] = 1;
        for (int i = 1; i < h + v; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= i && j < h; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        //依次求解各个位置的字符
        while (h > 0 && v > 0) {
            int low = dp[h + v - 1][h - 1];
            if (k > low) {
                sb.append("V");
                v--;
                //更新k值
                k -= low;
            } else {
                sb.append("H");
                h--;
            }
        }
        //如果"H"用完,则把剩余位置都是"V"
        if (h == 0) {
            for (int i = 0; i < v; i++) {
                sb.append("V");
            }
            //如果"V"用完,则剩余位置都是"H"
        } else {
            for (int i = 0; i < h; i++) {
                sb.append("H");
            }
        }
        return sb.toString();
    }
}
