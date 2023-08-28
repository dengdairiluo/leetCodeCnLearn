package com.yuren.leetcodecnlearn.Q1800;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-28 23:27
 */
public class Q1889 {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        int n = packages.length;
        long sum = 0;
        for (int x : packages)
            sum += x;
        Arrays.sort(packages);
        for (int[] box : boxes)
            Arrays.sort(box);
        final int mod = (int) 1e9 + 7;
        long answer = (long) 1e18;

        for (int[] box : boxes) {
            if (box[box.length - 1] < packages[n - 1]) continue;
            int j = 0;
            long current = 0;
            for (int i = 0; i < box.length; i += 1) {
                if (j == n) break;
                if (box[i] < packages[j]) continue;
                int l = j, r = n - 1;
                while (l < r) {
                    int m = (l + r + 1) >> 1;
                    if (packages[m] <= box[i]) l = m;
                    else r = m - 1;
                }
                current += (l - j + 1L) * box[i];
                j = l + 1;
            }
            answer = Math.min(answer, current - sum);
        }
        if (answer == (long) 1e18) answer = -1;
        answer %= mod;
        return (int) answer;
    }
}
