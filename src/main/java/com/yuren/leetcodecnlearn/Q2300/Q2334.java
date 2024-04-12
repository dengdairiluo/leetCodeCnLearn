package com.yuren.leetcodecnlearn.Q2300;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-03 23:55
 */
public class Q2334 {
    int[] fa;

    public int validSubarraySize(int[] nums, int threshold) {
        int n = nums.length;
        fa = new int[n + 1];
        for (int i = 0; i <= n; i++) fa[i] = i;
        int[] sz = new int[n + 1];

        Integer[] ids = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Arrays.sort(ids, (i, j) -> nums[j] - nums[i]);
        for (int i : ids) {
            int j = find(i + 1);
            fa[i] = j; // 合并 i 和 i+1
            sz[j] += sz[i] + 1;
            if (nums[i] > threshold / sz[j]) return sz[j];
        }
        return -1;
    }

    int find(int x) {
        if (fa[x] != x) fa[x] = find(fa[x]);
        return fa[x];
    }
}
