package com.yuren.leetcodecnlearn.Q2700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-23 00:48
 */
public class Q2736 {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = nums1[i];
            a[i][1] = nums2[i];
        }
        Arrays.sort(a, (x, y) -> y[0] - x[0]);

        Integer[] qid = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            qid[i] = i;
        }
        Arrays.sort(qid, (i, j) -> queries[j][0] - queries[i][0]);

        int[] ans = new int[queries.length];
        List<int[]> st = new ArrayList<>();
        int j = 0;
        for (int i : qid) {
            int x = queries[i][0], y = queries[i][1];
            // 下面只需关心 a[j][1]
            for (; j < n && a[j][0] >= x; j++) {
                // a[j][1] >= st.get(st.size()-1)[0]
                while (!st.isEmpty() && st.get(st.size() - 1)[1] <= a[j][0] + a[j][1]) {
                    st.remove(st.size() - 1);
                }
                if (st.isEmpty() || st.get(st.size() - 1)[0] < a[j][1]) {
                    st.add(new int[]{a[j][1], a[j][0] + a[j][1]});
                }
            }
            int p = lowerBound(st, y);
            ans[i] = p < st.size() ? st.get(p)[1] : -1;
        }
        return ans;
    }

    // 开区间写法，原理请看 b23.tv/AhwfbS2
    private int lowerBound(List<int[]> st, int target) {
        // 开区间 (left, right)
        int l = -1, r = st.size();
        // 区间不为空
        while (l + 1 < r) {
            int mid = (l + r) >>> 1;
            if (st.get(mid)[0] >= target) {
                // 范围缩小到 (left, mid)
                r = mid;
            } else {
                // 范围缩小到 (mid, right)
                l = mid;
            }
        }
        return r;
    }
}
