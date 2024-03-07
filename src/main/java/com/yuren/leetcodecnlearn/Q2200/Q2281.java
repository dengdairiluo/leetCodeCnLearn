package com.yuren.leetcodecnlearn.Q2200;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-07 23:10
 */
public class Q2281 {
    public int totalStrength(int[] strength) {
        final int mod = (int) 1e9 + 7;

        int n = strength.length;
        int[] left = new int[n];  // left[i] 为左侧严格小于 strength[i] 的最近元素位置（不存在时为 -1）
        int[] right = new int[n]; // right[i] 为右侧小于等于 strength[i] 的最近元素位置（不存在时为 n）
        Arrays.fill(right, n);
        Deque<Integer> st = new ArrayDeque<Integer>();
        st.push(-1); // 哨兵
        for (int i = 0; i < n; i++) {
            while (st.size() > 1 && strength[st.peek()] >= strength[i])
                right[st.pop()] = i;
            left[i] = st.peek();
            st.push(i);
        }

        long s = 0L; // 前缀和
        int[] ss = new int[n + 2]; // 前缀和的前缀和
        for (int i = 1; i <= n; ++i) {
            s += strength[i - 1];
            ss[i + 1] = (int) ((ss[i] + s) % mod); // 注意取模后，下面计算两个 ss 相减，结果可能为负
        }

        long ans = 0L;
        for (int i = 0; i < n; ++i) {
            int l = left[i] + 1, r = right[i] - 1; // [l,r] 左闭右闭
            long tot = ((long) (i - l + 1) * (ss[r + 2] - ss[i + 1]) - (long) (r - i + 1) * (ss[i + 1] - ss[l])) % mod;
            ans = (ans + strength[i] * tot) % mod; // 累加贡献
        }
        return (int) (ans + mod) % mod; // 防止算出负数
    }
}
