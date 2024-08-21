package com.yuren.leetcodecnlearn.Q2600;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-21 23:57
 */
public class Q2612 {
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        boolean[] ban = new boolean[n];
        ban[p] = true;
        for (int i : banned) ban[i] = true;
        TreeSet<Integer>[] sets = new TreeSet[2];
        sets[0] = new TreeSet<>();
        sets[1] = new TreeSet<>();
        for (int i = 0; i < n; i++)
            if (!ban[i])
                sets[i % 2].add(i);
        sets[0].add(n);
        sets[1].add(n); // 哨兵

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        List<Integer> q = new ArrayList<>();
        q.add(p);
        for (int step = 0; !q.isEmpty(); ++step) {
            List<Integer> tmp = q;
            q = new ArrayList<>();
            for (int i : tmp) {
                ans[i] = step;
                // 从 mn 到 mx 的所有位置都可以翻转到
                int mn = Math.max(i - k + 1, k - i - 1);
                int mx = Math.min(i + k - 1, n * 2 - k - i - 1);
                TreeSet<Integer> s = sets[mn % 2];
                for (Integer j = s.ceiling(mn); j <= mx; j = s.ceiling(mn)) {
                    q.add(j);
                    s.remove(j);
                }
            }
        }
        return ans;
    }
}
