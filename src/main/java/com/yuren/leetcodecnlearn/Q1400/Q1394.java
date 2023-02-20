package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-20 23:47
 */
public class Q1394 {
    public int findLucky(int[] arr) {
        int[] p = new int[510];
        int n = arr.length;
        int maxAns = 0;
        for (int i = 0; i < n; i++) {
            p[arr[i]]++;
            maxAns = Math.max(maxAns, arr[i]);
        }
        for (int i = maxAns; i > 0; i--) {
            if (p[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
