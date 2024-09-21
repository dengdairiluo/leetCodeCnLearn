package com.yuren.leetcodecnlearn.Q2600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-22 03:34
 */
public class Q2672 {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] c = new int[n];
        int len = queries.length;
        int[] ret = new int[len];
        int cnt = 0;

        for (int i = 0; i < len; ++i) {
            int k = queries[i][0];
            if (c[k] > 0) {
                // 原来有着色，判断左右相邻的连个格子，
                // 如果颜色相同，则减一
                if (k > 0 && c[k - 1] == c[k]) --cnt;
                if (k < n - 1 && c[k] == c[k + 1]) --cnt;
            }
            // 重新着色
            c[k] = queries[i][1];
            // 如果与相邻的格子相同，则加一
            if (k > 0 && c[k - 1] == c[k]) ++cnt;
            if (k < n - 1 && c[k] == c[k + 1]) ++cnt;

            ret[i] = cnt;
        }

        return ret;
    }
}
