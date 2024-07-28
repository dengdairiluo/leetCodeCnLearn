package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-28 下午10:35
 */
public class Q2565 {
    public int minimumScore(String s, String t) {
        char[] charS = s.toCharArray(), charT = t.toCharArray();
        int n = charS.length, m = charT.length;
        int[] suf = new int[n + 1];
        suf[n] = m;
        for (int i = n - 1, j = m - 1; i >= 0; --i) {
            if (j >= 0 && charS[i] == charT[j]) --j;
            suf[i] = j + 1;
        }
        // 删除 t[:suf[0]]
        int ans = suf[0];
        if (ans == 0) return 0;
        for (int i = 0, j = 0; i < n; ++i)
            // 注意 j 不会等于 m，因为上面 suf[0]>0 表示 t 不是 s 的子序列
            if (charS[i] == charT[j])
                // ++j 后，删除 t[j:suf[i+1]]
                ans = Math.min(ans, suf[i + 1] - ++j);
        return ans;
    }
}
