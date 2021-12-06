package com.yuren.leetcodecnlearn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-12-06 23:46
 */
public class Q354 {
    int[] tree;
    int lowbit(int x) {
        return x & -x;
    }

    public int maxEnvelopes(int[][] es) {
        int n = es.length;
        if (n == 0) return n;

        // 由于我们使用了 g 记录高度，因此这里只需将 w 从小到达排序即可
        Arrays.sort(es, (a, b)->a[0] - b[0]);

        // 先将所有的 h 进行离散化
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) set.add(es[i][1]);
        int cnt = set.size();
        int[] hs = new int[cnt];
        int idx = 0;
        for (int i : set) hs[idx++] = i;
        Arrays.sort(hs);
        for (int i = 0; i < n; i++) es[i][1] = Arrays.binarySearch(hs, es[i][1]) + 1;

        // 创建树状数组
        tree = new int[cnt + 1];

        // f(i) 为考虑前 i 个物品，并以第 i 个物品为结尾的最大值
        int[] f = new int[n];
        int ans = 1;
        for (int i = 0, j = 0; i < n; i++) {
            // 对于 w 相同的数据，不更新 tree 数组
            if (es[i][0] != es[j][0]) {
                // 限制 j 不能越过 i，确保 tree 数组中只会出现第 i 个信封前的「历史信封」
                while (j < i) {
                    for (int u = es[j][1]; u <= cnt; u += lowbit(u)) {
                        tree[u] = Math.max(tree[u], f[j]);
                    }
                    j++;
                }
            }
            f[i] = 1;
            for (int u = es[i][1] - 1; u > 0; u -= lowbit(u)) {
                f[i] = Math.max(f[i], tree[u] + 1);
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}
