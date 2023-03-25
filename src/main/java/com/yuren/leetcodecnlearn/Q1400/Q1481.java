package com.yuren.leetcodecnlearn.Q1400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-25 21:09
 */
public class Q1481 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int larr = arr.length;
        int[] lenSlice = new int[larr];
        Map<Integer, Integer> table = new HashMap<>(larr);
        int l = 0;

        for (int i : arr) {
            Integer v = table.get(i);
            if (v != null) {
                lenSlice[v]++;
            } else {
                table.put(i, l);
                lenSlice[l] = 1;
                l++;
            }
        }
        if (k == 0) {
            return l;
        }
        Arrays.sort(lenSlice);
        for (int idx = 0; k > 0; idx++) {
            if (lenSlice[idx] == 0) {
                continue;
            }
            k -= lenSlice[idx];
            if (k < 0) {
                return l;
            }
            l--;
        }
        return l;
    }
}
