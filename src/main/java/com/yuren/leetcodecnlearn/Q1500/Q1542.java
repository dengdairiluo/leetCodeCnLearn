package com.yuren.leetcodecnlearn.Q1500;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-19 23:47
 */
public class Q1542 {
    public int longestAwesome(String s) {
        int[] pos = new int[1 << 10];
        int n = s.length();
        Arrays.fill(pos, n);
        pos[0] = -1;
        int ans = 0;
        for (int i = 0, v = 0; i < n; i++) {
            int num = s.charAt(i) - '0';
            v = v ^ (1 << num);
            ans = Math.max(i - pos[v], ans);
            pos[v] = Math.min(pos[v], i);
            for (int j = 0; j < 10; j++) {
                ans = Math.max(i - pos[v ^ (1 << j)], ans);
            }
        }
        return ans;
    }
}
