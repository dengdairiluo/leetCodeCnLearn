package com.yuren.leetcodecnlearn.Q2000;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-02 23:50
 */
public class Q2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length, cnt = m + n;
        int t = mean * cnt;
        for (int i : rolls) t -= i;
        if (t < n || t > 6 * n) return new int[0];
        int[] ans = new int[n];
        Arrays.fill(ans, t / n);
        int d = t - (t / n * n), idx = 0;
        while (d-- > 0) ans[idx++]++;
        return ans;
    }
}
