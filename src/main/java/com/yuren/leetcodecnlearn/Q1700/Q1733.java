package com.yuren.leetcodecnlearn.Q1700;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-01 23:49
 */
public class Q1733 {
    class Solution {
        public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
            Set<Integer> pl = new HashSet<>();
            int[] cnt = new int[n];
            for (int[] f : friendships) {
                boolean[] v = new boolean[n];
                boolean s = true;
                for (int l : languages[f[0] - 1]) {
                    v[l - 1] = true;
                }
                for (int l : languages[f[1] - 1]) {
                    if (v[l - 1]) {
                        s = false;
                        break;
                    }
                }
                if (s) {
                    pl.add(f[0] - 1);
                    pl.add(f[1] - 1);
                }
            }
            int max = 0;
            for (int p : pl) {
                for (int l : languages[p]) {
                    max = Math.max(max, ++cnt[l - 1]);
                }
            }
            return pl.size() - max;
        }
    }
}
