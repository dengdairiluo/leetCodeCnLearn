package com.yuren.leetcodecnlearn.Q2200;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-04 23:25
 */
public class Q2274 {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int n = special.length;
        if (top - bottom + 1 == n) {
            return 0;
        }
        Arrays.sort(special);
        int ans = Math.max(special[0] - bottom, top - special[n - 1]);
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, special[i] - special[i - 1] - 1);
        }
        return ans;
    }
}
