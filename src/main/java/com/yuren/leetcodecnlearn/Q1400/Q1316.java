package com.yuren.leetcodecnlearn.Q1400;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-21 23:52
 */
public class Q1316 {
    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        int[] h = new int[n + 1], p = new int[n + 1];
        int base = 131;
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            h[i] = h[i - 1] * base + text.charAt(i - 1);
            p[i] = p[i - 1] * base;
        }
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j += 2) {
                int len = (j - i + 1) >> 1;
                int hash1 = h[j - len] - h[i - 1] * p[len];
                int hash2 = h[j] - h[j - len] * p[len];
                if (hash1 == hash2 && !set.contains(hash1)) {
                    set.add(hash1);
                    ans++;
                }
            }
        }
        return ans;
    }
}
