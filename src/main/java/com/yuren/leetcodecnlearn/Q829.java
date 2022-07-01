package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-01 23:39
 */
public class Q829 {
    public int consecutiveNumbersSum(int n) {
        int t = 2 * n, ans = 0;
        for (int k = 1; k * k < t; k++) {
            if (t % k == 0 && (t / k + 1 - k) % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
