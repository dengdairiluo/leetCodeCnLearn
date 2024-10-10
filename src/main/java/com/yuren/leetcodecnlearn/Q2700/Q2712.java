package com.yuren.leetcodecnlearn.Q2700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-10 22:52
 */
public class Q2712 {
    public long minimumCost(String S) {
        long ans = 0;
        char[] s = S.toCharArray();
        int n = s.length;
        for (int i = 1; i < n; i++)
            if (s[i - 1] != s[i])
                ans += Math.min(i, n - i);
        return ans;
    }
}
