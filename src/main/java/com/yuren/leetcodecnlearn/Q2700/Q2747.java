package com.yuren.leetcodecnlearn.Q2700;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-28 00:00
 */
public class Q2747 {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int nq = queries.length;
        Integer[] id = new Integer[nq];
        for (int i = 0; i < nq; i++) id[i] = i;
        Arrays.sort(id, Comparator.comparingInt(i -> queries[i]));
        Arrays.sort(logs, Comparator.comparingInt(a -> a[1])); // 按照 time 排序

        int[] ans = new int[nq], cnt = new int[n + 1];
        int outOfRange = n, left = 0, right = 0;
        for (int i : id) {
            while (right < logs.length && logs[right][1] <= queries[i]) // 进入窗口
                if (cnt[logs[right++][0]]++ == 0)
                    outOfRange--;
            while (left < logs.length && logs[left][1] < queries[i] - x) // 离开窗口
                if (--cnt[logs[left++][0]] == 0)
                    outOfRange++;
            ans[i] = outOfRange;
        }
        return ans;
    }
}
