package com.yuren.leetcodecnlearn.Q2700;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-11-04 23:42
 */
public class Q2763 {
    public int sumImbalanceNumbers(int[] nums) {
        int ans = 0, n = nums.length;
        boolean[] vis = new boolean[n + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(vis, false);
            vis[nums[i]] = true;
            int cnt = 0;
            for (int j = i + 1; j < n; j++) {
                int x = nums[j];
                if (!vis[x]) {
                    cnt++;
                    if (vis[x - 1]) cnt--;
                    if (vis[x + 1]) cnt--;
                    vis[x] = true;
                }
                ans += cnt;
            }
        }
        return ans;
    }
}
