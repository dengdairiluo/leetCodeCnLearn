package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-28 下午11:05
 */
public class Q2382 {

    int[] fa;

    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int n = nums.length;
        fa = new int[n + 1];
        for (int i = 0; i <= n; i++) fa[i] = i;
        long[] sum = new long[n + 1];

        long[] ans = new long[n];
        for (int i = n - 1; i > 0; --i) {
            int x = removeQueries[i];
            int to = find(x + 1);
            fa[x] = to; // 合并 x 和 x+1
            sum[to] += sum[x] + nums[x];
            ans[i - 1] = Math.max(ans[i], sum[to]);
        }
        return ans;
    }

    int find(int x) {
        if (fa[x] != x) fa[x] = find(fa[x]);
        return fa[x];
    }
}
