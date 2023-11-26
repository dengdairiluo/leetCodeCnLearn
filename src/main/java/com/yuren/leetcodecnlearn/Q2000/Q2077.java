package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-26 23:35
 */
public class Q2077 {
    public int numberOfPaths(int n, int[][] corridors) {
        boolean[][] arr = new boolean[n][n];
        for (int[] corridor : corridors) {
            arr[corridor[0] - 1][corridor[1] - 1] = true;
            arr[corridor[1] - 1][corridor[0] - 1] = true;
        }
        int ans = 0;
        for (int[] corridor : corridors) {
            //只遍历比边上两点序号都小的第三点以便去重
            for (int i = 0; i < Math.min(corridor[0], corridor[1]) - 1; i++) {
                if (arr[corridor[0] - 1][i] && arr[corridor[1] - 1][i]) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
