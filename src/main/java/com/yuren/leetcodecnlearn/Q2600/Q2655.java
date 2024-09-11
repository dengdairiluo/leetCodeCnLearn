package com.yuren.leetcodecnlearn.Q2600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-12 00:49
 */
public class Q2655 {
    public int[][] findMaximalUncoveredRanges(int n, int[][] ranges) {
        List<int[]> uncovered = new ArrayList<int[]>();
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));
        int prev = -1;
        int length = ranges.length;
        for (int i = 0; i <= length; i++) {
            int[] range = i < length ? ranges[i] : new int[]{n, n};
            if (range[0] - prev > 1) {
                uncovered.add(new int[]{prev + 1, range[0] - 1});
            }
            prev = Math.max(prev, range[1]);
        }
        return uncovered.toArray(new int[uncovered.size()][]);
    }
}
