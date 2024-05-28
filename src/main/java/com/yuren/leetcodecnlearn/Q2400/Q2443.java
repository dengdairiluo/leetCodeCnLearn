package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-28 下午11:08
 */
public class Q2443 {
    private static final int MX = (int) (1e5 + 1);
    private static final boolean[] ans = new boolean[MX];

    static {
        for (int i = 0; i < MX; i++) {
            int rev = 0;
            for (int x = i; x > 0; x /= 10) rev = 10 * rev + x % 10;
            int sum = i + rev;
            if (sum < MX) ans[sum] = true;
        }
    }

    public boolean sumOfNumberAndReverse(int num) {
        return ans[num];
    }
}
