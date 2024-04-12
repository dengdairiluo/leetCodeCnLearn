package com.yuren.leetcodecnlearn.Q2300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-07 下午11:05
 */
public class Q2343 {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        Integer[] qid = IntStream.range(0, queries.length).boxed().toArray(Integer[]::new);
        Arrays.sort(qid, Comparator.comparingInt(i -> queries[i][1]));

        int m = nums[0].length();
        List<Integer> idx = new ArrayList<>(Arrays.asList(IntStream.range(0, nums.length).boxed().toArray(Integer[]::new)));

        int[] ans = new int[queries.length];
        int p = 1;
        for (int qi : qid) {
            int[] q = queries[qi];
            while (p <= q[1]) {
                final int pp = p++;
                idx.sort(Comparator.comparingInt(i -> nums[i].charAt(m - pp))); // 稳定排序
            }
            ans[qi] = idx.get(q[0] - 1);
        }
        return ans;
    }
}
