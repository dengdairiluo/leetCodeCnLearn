package com.yuren.leetcodecnlearn.Q2500;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-21 下午10:41
 */
public class Q2551 {
    public long putMarbles(int[] wt, int k) {
        int n = wt.length;
        for (int i = 0; i < n - 1; ++i)
            wt[i] += wt[i + 1];
        // 相当于去掉最后一个数
        Arrays.sort(wt, 0, n - 1);
        long ans = 0;
        for (int i = 0; i < k - 1; ++i)
            ans += wt[n - 2 - i] - wt[i];
        return ans;
    }
}
