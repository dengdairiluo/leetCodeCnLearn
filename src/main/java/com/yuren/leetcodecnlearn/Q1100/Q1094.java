package com.yuren.leetcodecnlearn.Q1100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-21 23:26
 */
public class Q1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] hash = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            int[] t = trips[i];
            int p = t[0], f = t[1], to = t[2];
            hash[f] += p;
            hash[to] -= p;
        }
        int num = 0;
        for (int i = 0; i < hash.length; i++) {
            num += hash[i];
            if (num > capacity) {
                return false;
            }
        }
        return true;
    }
}
