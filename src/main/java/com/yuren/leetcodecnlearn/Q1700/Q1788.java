package com.yuren.leetcodecnlearn.Q1700;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-22 22:38
 */
public class Q1788 {
    public int maximumBeauty(int[] flowers) {
        int start;
        int n = flowers.length;
        int end;
        int[] preSum = new int[n];
        int pre = 0;
        for (int i = 0; i < n; i++) {
            pre += flowers[i];
            preSum[i] = pre;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int flower : flowers) {
            set.add(flower);
        }
        List<Integer> set1 = new ArrayList<>(set);
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        //利用两个哈希表存储  值开始的为质，和结束的最大位置
        for (int i = 0; i < n; i++) {
            int k = flowers[i];
            map.put(k, Math.min(map.getOrDefault(k, i), i));
            map2.put(k, Math.max(map.getOrDefault(k, i), i));
        }
        //去掉所有不美观的值保存最大的
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for (Integer integer : set1) {
            start = map.get(integer);
            end = map2.get(integer);
            if (start == end) {
                continue;
            }
            for (int j = start + 1; j < end; j++) {
                if (flowers[j] < 0) {
                    ans += -flowers[j];
                }
            }
            if (start - 1 >= 0) {
                ans += preSum[end] - preSum[start - 1];
            } else {
                ans += preSum[end];
            }
            max = Math.max(ans, max);
            ans = 0;
        }
        return max;

    }
}
