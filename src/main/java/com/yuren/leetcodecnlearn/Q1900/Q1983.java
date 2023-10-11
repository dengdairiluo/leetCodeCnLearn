package com.yuren.leetcodecnlearn.Q1900;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-11 23:40
 */
public class Q1983 {
    public int widestPairOfIndices(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] diffs = new int[n];
        for (int i = 0; i < n; i++) {
            diffs[i] = nums1[i] - nums2[i];
        }
        int[] prefixSums = new int[n];
        prefixSums[0] = diffs[0];
        for (int i = 1; i < n; i++) {
            prefixSums[i] = prefixSums[i - 1] + diffs[i];
        }
        int maxDistance = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            int sum = prefixSums[i];
            if (map.containsKey(sum)) {
                maxDistance = Math.max(maxDistance, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxDistance;
    }
}
