package com.yuren.leetcodecnlearn.Q2000;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-23 23:08
 */
public class Q2070 {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = queries.length, m = items.length;
        int[] ans = new int[n];
        Arrays.sort(items, (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (items[j][0] <= queries[i]) {
                    ans[i] = items[j][1];
                    break;
                }
            }
        }
        return ans;
    }
}
