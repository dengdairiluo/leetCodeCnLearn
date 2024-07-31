package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-31 下午11:53
 */
public class Q2571 {
    public int minOperations(int n) {
        int ans = 1;
        while ((n & (n - 1)) > 0) { // n 不是 2 的幂次
            int lb = n & -n;
            if ((n & (lb << 1)) > 0) n += lb; // 多个连续 1
            else n -= lb; // 单个 1
            ++ans;
        }
        return ans;
    }
}
