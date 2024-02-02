package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-02 23:42
 */
public class Q2213 {
    char[] s;
    int[] pre, suf, max;

    void maintain(int o, int l, int r) {
        pre[o] = pre[o << 1];
        suf[o] = suf[o << 1 | 1];
        max[o] = Math.max(max[o << 1], max[o << 1 | 1]);
        int m = (l + r) >> 1;
        if (s[m - 1] == s[m]) { // 中间字符相同，可以合并
            if (suf[o << 1] == m - l + 1) pre[o] += pre[o << 1 | 1];
            if (pre[o << 1 | 1] == r - m) suf[o] += suf[o << 1];
            max[o] = Math.max(max[o], suf[o << 1] + pre[o << 1 | 1]);
        }
    }

    void build(int o, int l, int r) {
        if (l == r) {
            pre[o] = suf[o] = max[o] = 1;
            return;
        }
        int m = (l + r) / 2;
        build(o << 1, l, m);
        build(o << 1 | 1, m + 1, r);
        maintain(o, l, r);
    }

    void update(int o, int l, int r, int i) {
        if (l == r) return;
        int m = (l + r) / 2;
        if (i <= m) update(o << 1, l, m, i);
        else update(o << 1 | 1, m + 1, r, i);
        maintain(o, l, r);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        this.s = s.toCharArray();
        int n = this.s.length, m = queryIndices.length;
        pre = new int[n << 2];
        suf = new int[n << 2];
        max = new int[n << 2];
        build(1, 1, n);
        int[] ans = new int[m];
        for (int i = 0; i < m; ++i) {
            this.s[queryIndices[i]] = queryCharacters.charAt(i);
            update(1, 1, n, queryIndices[i] + 1);
            ans[i] = max[1];
        }
        return ans;
    }
}
