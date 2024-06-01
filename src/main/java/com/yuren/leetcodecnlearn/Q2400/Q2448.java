package com.yuren.leetcodecnlearn.Q2400;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-01 下午11:48
 */
public class Q2448 {
    public long minCost(int[] nums, int[] cost) {
        int N = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        // 去重，相同的数字可以合并cost
        for (int i = 0; i < N; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + cost[i]);
        }
        if (map.size() == 1) return 0;
        long ans = Long.MAX_VALUE;
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.size());
        list.addAll(map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getKey));
        long tmp = 0;
        // 计算前缀和
        long[] costSums = new long[list.size() + 1];
        for (int j = 1; j <= list.size(); j++) {
            costSums[j] = costSums[j - 1] + list.get(j - 1).getValue();
        }
        for (int i = 0; i < list.size(); i++) {
            tmp += (long) (list.get(list.size() - 1).getKey() - list.get(i).getKey()) * list.get(i).getValue();
        }
        ans = Math.min(ans, tmp);
        for (int i = list.size() - 2; i >= 0; i--) {
            long right = (list.get(i + 1).getKey() - list.get(i).getKey()) * (costSums[list.size()] - costSums[i + 1]);
            long left = (list.get(i + 1).getKey() - list.get(i).getKey()) * costSums[i + 1];
            tmp = tmp - left + right;
            if (ans > tmp) {
                ans = tmp;
            }
        }
        return ans;
    }
}
