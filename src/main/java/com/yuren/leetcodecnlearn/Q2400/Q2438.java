package com.yuren.leetcodecnlearn.Q2400;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-26 下午10:45
 */
public class Q2438 {
    public int[] productQueries(int n, int[][] queries) {
        int mod = (int) (1e9 + 7);
        int m = queries.length;
        int[] ans = new int[m];
        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            int lowbit = n & -n;
            list.add(lowbit);
            n ^= lowbit;
        }
        int size = list.size();
        int[][] res = new int[size][size];
        for (int i = 0; i < size; i++) {
            res[i][i] = (int) (list.get(i) % mod);
            for (int j = i + 1; j < size; j++) {
                res[i][j] = (int) (1l * res[i][j - 1] * list.get(j) % mod);
            }
        }
        for (int i = 0; i < m; i++) {
            ans[i] = res[queries[i][0]][queries[i][1]];
        }
        return ans;
    }
}
