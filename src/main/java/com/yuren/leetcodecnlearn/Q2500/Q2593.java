package com.yuren.leetcodecnlearn.Q2500;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-11 22:27
 */
public class Q2593 {
    public long findScore(int[] nums) {
        int n = nums.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; ++i) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(i -> nums[i]));

        long ans = 0;
        boolean[] vis = new boolean[n + 2]; // 保证下标不越界
        for (int i : ids)
            if (!vis[i + 1]) { // 避免 -1，偏移一位
                vis[i] = vis[i + 2] = true;
                ans += nums[i];
            }
        return ans;
    }
}
