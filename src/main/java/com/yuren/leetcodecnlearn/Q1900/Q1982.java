package com.yuren.leetcodecnlearn.Q1900;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-10 23:35
 */
public class Q1982 {
    public int[] recoverArray(int n, int[] sums) {
        int[] ans = new int[n];
        if (n == 1) {
            if (sums[0] == 0) {
                ans[0] = sums[1];
            } else {
                ans[0] = sums[0];
            }
            return ans;
        }
        Arrays.sort(sums);
        int d = sums[1] - sums[0];
        int[] s = new int[sums.length / 2];
        int[] t = new int[sums.length / 2];
        boolean[] used = new boolean[sums.length];
        int l = 0, r = 0;
        boolean sFlag = false;
        for (int i = 0; i < s.length; i++) {
            while (l < sums.length && used[l]) {
                l++;
            }
            s[i] = sums[l];
            used[l] = true;
            if (s[i] == 0) {
                sFlag = true;
            }
            while (r < sums.length && (used[r] || sums[r] - sums[l] != d)) {
                r++;
            }
            t[i] = sums[r];
            used[r] = true;

        }

        if (sFlag) {
            int[] res = recoverArray(n - 1, s);
            System.arraycopy(res, 0, ans, 0, res.length);
            ans[ans.length - 1] = d;
        } else {
            int[] res = recoverArray(n - 1, t);
            System.arraycopy(res, 0, ans, 0, res.length);
            ans[ans.length - 1] = -d;
        }
        return ans;
    }
}
