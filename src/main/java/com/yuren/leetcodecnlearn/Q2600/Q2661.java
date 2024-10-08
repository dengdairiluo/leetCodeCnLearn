package com.yuren.leetcodecnlearn.Q2600;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-14 22:41
 */
public class Q2661 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length, m = mat[0].length;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        int[] c1 = new int[n], c2 = new int[m];
        for (int i = 0; i < n * m; i++) {
            int[] info = map.get(arr[i]);
            int x = info[0], y = info[1];
            if (++c1[x] == m || ++c2[y] == n) return i;
        }
        return -1; // never
    }
}
