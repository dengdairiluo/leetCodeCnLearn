package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-07 22:03
 */
public class Q2223 {
    public long sumScores(String s) {
        int n = s.length();
        int[] z = new int[n];
        long ans = n;
        for (int i = 1, l = 0, r = 0; i < n; i++) {
            z[i] = Math.max(Math.min(z[i - l], r - i + 1), 0);
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                l = i;
                r = i + z[i];
                z[i]++;
            }
            ans += z[i];
        }
        return ans;
    }

}
