package com.yuren.leetcodecnlearn.Q2700;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-08 00:09
 */
public class Q2707 {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>(dictionary.length);
        Collections.addAll(set, dictionary);
        int n = s.length();
        int[] f = new int[n + 1];
        for (int i = 0; i < n; i++) {
            f[i + 1] = f[i] + 1; // 不选
            for (int j = 0; j <= i; j++) { // 枚举选哪个
                if (set.contains(s.substring(j, i + 1))) {
                    f[i + 1] = Math.min(f[i + 1], f[j]);
                }
            }
        }
        return f[n];
    }
}
