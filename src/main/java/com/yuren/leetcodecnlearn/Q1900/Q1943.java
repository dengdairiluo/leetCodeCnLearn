package com.yuren.leetcodecnlearn.Q1900;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-21 23:32
 */
public class Q1943 {
    public List<List<Long>> splitPainting(int[][] segments) {
        List<List<Long>> result = new ArrayList<>();
        int n = 1;

        for (int[] s : segments) {
            n = Math.max(n, s[1]);
        }
        n += 1;

        long[] line = new long[n];
        boolean[] endpoint = new boolean[n];

        for (int[] s : segments) {
            int start = s[0], end = s[1], color = s[2];
            line[start] += color;
            line[end] -= color;
            endpoint[start] = endpoint[end] = true;
        }

        long mixedColor = 0;
        for (int end = 1, start = 1; end < n; end++) {
            if (endpoint[end]) {
                if (mixedColor > 0) {
                    result.add(Arrays.asList((long) start, (long) end, mixedColor));
                }
                start = end;
            }

            mixedColor += line[end];
        }

        return result;
    }
}
