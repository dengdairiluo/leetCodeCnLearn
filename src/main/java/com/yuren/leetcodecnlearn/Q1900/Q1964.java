package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-07 22:43
 */
public class Q1964 {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] st = new int[n];
        int[] ans = new int[n];
        int tot = -1;
        for (int i = 0; i < n; i++) {
            if (tot < 0 || st[tot] <= obstacles[i]) {
                st[++tot] = obstacles[i];
                ans[i] = tot + 1;
            } else {
                int l = 0, r = tot;
                while (l <= r) {
                    int mid = l + r >> 1;
                    if (st[mid] <= obstacles[i]) l = mid + 1;
                    else r = mid - 1;
                }
                st[l] = obstacles[i];
                ans[i] = l + 1;
            }
        }
        return ans;
    }
}
