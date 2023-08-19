package com.yuren.leetcodecnlearn.Q1800;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-19 19:50
 */
public class Q1865 {
    int[] nums1;
    int[] nums2;
    Map<Integer, Integer> map;

    public Q1865(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        this.nums1 = nums1;
        this.nums2 = nums2;
        map = new HashMap<>(nums2.length << 2);
        for (int j : nums2) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int x = nums2[index];
        map.put(x, map.getOrDefault(x, 0) - 1);
        nums2[index] += val;
        x += val;
        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    public int count(int tot) {
        int ans = 0;
        for (int j : nums1) {
            if (j >= tot) {
                break;
            }
            int delta = tot - j;
            ans += map.getOrDefault(delta, 0);
        }
        return ans;
    }
}
