package com.yuren.leetcodecnlearn.Q1600;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-03 23:45
 */
public class Q1655 {
    public boolean canDistribute(int[] nums, int[] quantity) {
        int[] counts = new int[1001];
        for (int num : nums) {
            counts[num]++;
        }
        TreeMap<Integer, Integer> maps = new TreeMap<>();

        for (int count : counts) {
            if (count > 0) {
                maps.put(count, maps.getOrDefault(count, 0) + 1);
            }
        }

        Arrays.sort(quantity);

        return dfs(maps, quantity, quantity.length - 1);
    }

    private boolean dfs(TreeMap<Integer, Integer> maps, int[] quantity, int i) {
        if (i == 0) {
            return maps.ceilingKey(quantity[i]) != null;
        }

        Map.Entry<Integer, Integer> entry = maps.ceilingEntry(quantity[i]);
        while (entry != null) {
            //remove entry
            if (entry.getValue() == 1) {
                maps.remove(entry.getKey());
            } else {
                maps.put(entry.getKey(), entry.getValue() - 1);
            }

            //add new entry
            int remain = entry.getKey() - quantity[i];
            int remainVal = maps.getOrDefault(remain, 0) + 1;
            if (remain > 0) {
                maps.put(remain, remainVal);
            }
            if (dfs(maps, quantity, i - 1)) {
                return true;
            }

            //restore map
            if (remain > 0) {
                if (remainVal == 1) {
                    maps.remove(remain);
                } else {
                    maps.put(remain, remainVal - 1);
                }
            }
            maps.put(entry.getKey(), entry.getValue());

            entry = maps.ceilingEntry(entry.getKey() + 1);
        }
        return false;
    }
}
