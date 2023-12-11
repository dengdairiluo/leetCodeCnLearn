package com.yuren.leetcodecnlearn.Q2100;

import java.util.HashSet;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-11 22:29
 */
public class Q2107 {
    public int shareCandies(int[] candies, int k) {
        int n = candies.length;
        HashSet<Integer> set = new HashSet<>();
        int[] b = new int[100002];
        for (int i = 0; i < n; i++) {
            set.add(candies[i]);
            b[candies[i]]++;


        }
        int m = set.size();
        int min = m;
        int[] a = new int[100002];

        int c = 0;
        for (int i = 0; i < k; i++) {
            a[candies[i]]++;
            if (a[candies[i]] == b[candies[i]]) {
                c++;
            }
        }
        min = Math.min(min, c);
        for (int i = k; i < n; i++) {
            a[candies[i]]++;
            if (a[candies[i]] == b[candies[i]]) {
                c++;
            }
            a[candies[i - k]]--;
            if (a[candies[i - k]] == b[candies[i - k]] - 1) {
                c--;
            }
            min = Math.min(min, c);
        }
        return m - min;


    }
}
