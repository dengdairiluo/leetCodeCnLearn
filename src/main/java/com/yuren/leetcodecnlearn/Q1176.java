package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-26 23:47
 */
public class Q1176 {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        // 后缀前置操作
        int pre = 0;
        int ans = 0;
        int n = calories.length;
        for (int i = n - k + 1; i < n; i++) {
            pre += calories[i];
        }
        for (int i = n - k; i >= 0; i--) {
            pre += calories[i];
            if (pre < lower) {
                ans--;
            }
            if (pre > upper) {
                ans++;
            }
            pre -= calories[i + k - 1];
        }

        return ans;
    }
}
