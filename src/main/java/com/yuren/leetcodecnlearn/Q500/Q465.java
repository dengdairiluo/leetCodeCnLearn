package com.yuren.leetcodecnlearn.Q500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q465 {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> mp = new HashMap<>();

        int initalCount = 0;
        for (int[] t : transactions) {
            map.put(t[0], map.getOrDefault(t[0], 0) - t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) + t[2]);
        }
        List<Integer> list = new ArrayList<>(map.values());
        // 剪枝 1
        list.removeIf(n -> (n == 0));

        // 剪枝 2
        for (int i = 0; i < list.size(); i++) {
            mp.computeIfAbsent(list.get(i), k -> new ArrayList<>()).add(i);
        }
        for (int key : mp.keySet()) {

            if (mp.containsKey(-key) && key > 0) {
                int max = Math.min(mp.get(key).size(), mp.get(-key).size());
                int step = 0;
                while (step < max) {
                    list.set(mp.get(key).get(step), 0);
                    list.set(mp.get(-key).get(step), 0);
                    step++;
                    initalCount++;
                }
            }
        }
        list.removeIf(n -> (n == 0));

        return list.size() > 0 ? dfs(list, 0) + initalCount : initalCount;
    }

    public int dfs(List<Integer> list, int pos) {
        if (pos == list.size() - 2) return list.get(list.size() - 2) == 0 ? 0 : 1;
        if (list.get(pos) == 0) return dfs(list, pos + 1);
        int trans = Integer.MAX_VALUE;
        for (int i = pos + 1; i < list.size(); i++) {
            int balance = list.get(i);
            if (balance * list.get(pos) < 0) {
                list.set(i, balance + list.get(pos));
                trans = Math.min(trans, 1 + dfs(list, pos + 1));
                list.set(i, balance);
            }
        }
        return trans;

    }
}
