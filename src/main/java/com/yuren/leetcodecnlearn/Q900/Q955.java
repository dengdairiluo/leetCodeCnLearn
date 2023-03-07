package com.yuren.leetcodecnlearn.Q900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-24 00:05
 */
public class Q955 {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        int[] vis = new int[n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            boolean isDelete = false;
            for (int j = 1; j < n; j++) {
                if (vis[j] == 1) {
                    continue;
                }
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    isDelete = true;
                    break;
                }
            }
            if (isDelete) {
                ans++;
            } else {
                for (int j = 1; j < n; j++) {
                    if (strs[j].charAt(i) > strs[j - 1].charAt(i)) {
                        vis[j] = 1;
                    }
                }
            }
        }
        return ans;
    }
}
