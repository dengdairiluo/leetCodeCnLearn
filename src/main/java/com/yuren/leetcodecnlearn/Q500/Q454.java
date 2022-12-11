package com.yuren.leetcodecnlearn.Q500;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-01-16 22:53
 */
public class Q454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> count12 = new HashMap<>();
        for (int u : nums1) {
            for (int v : nums2) {
                count12.put(u + v, count12.getOrDefault(u + v, 0) + 1);
            }
        }
        int ans = 0;
        for (int u : nums3) {
            for (int v : nums4) {
                if (count12.containsKey(-u - v)) {
                    ans += count12.get(-u - v);
                }
            }
        }
        return ans;
    }
}
