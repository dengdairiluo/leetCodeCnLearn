package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-16 22:58
 */
public class Q1536 {

    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] hash = new int[n];
        for (int i = 0, p = n - 1; i < n; i++, p--) {
            for (int j = n - 1; j >= 0 && grid[i][j] == 0; j--) {
                hash[p]++;
            }
        }
        int ans = 0;
        for (int i = n - 1; i > 0; i--) {
            boolean ok = false;
            for (int j = i; j >= 0; j--) {
                if (hash[j] >= i) {
                    ans += i - j;
                    for (int k = j; k < i; k++) {
                        hash[k] = hash[k + 1];
                    }
                    ok = true;
                    break;
                }
            }
            if (!ok) {
                return -1;
            }
        }
        return ans;
    }
}
