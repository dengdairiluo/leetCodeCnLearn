package com.yuren.leetcodecnlearn.Q300;

import java.util.HashMap;
import java.util.Map;

public class Q325 {
    public int maxSubArrayLen(int[] nums, int k) {
        //哈希表存储值和下标
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        map.put(0, 0);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (map.containsKey(pre[i] - k)) {
                max = Math.max(max, i - map.get(pre[i] - k));
            }
            if (!map.containsKey(pre[i])) {
                map.put(pre[i], i);
            }

        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
