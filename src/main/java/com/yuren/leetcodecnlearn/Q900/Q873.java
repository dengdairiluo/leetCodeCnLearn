package com.yuren.leetcodecnlearn.Q900;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-22 21:06
 */
public class Q873 {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0 && j + 2 > ans; j--) {
                if (arr[i] - arr[j] >= arr[j]) {
                    break;
                }
                int t = map.getOrDefault(arr[i] - arr[j], -1);
                if (t == -1) {
                    continue;
                }
                f[i][j] = Math.max(3, f[j][t] + 1);
                ans = Math.max(ans, f[i][j]);
            }
        }
        return ans;
    }
}
