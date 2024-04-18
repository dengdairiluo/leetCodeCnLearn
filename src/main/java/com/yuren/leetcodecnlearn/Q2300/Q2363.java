package com.yuren.leetcodecnlearn.Q2300;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-18 下午11:18
 */
public class Q2363 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] v : items1) {
            map.put(v[0], map.getOrDefault(v[0], 0) + v[1]);
        }
        for (int[] v : items2) {
            map.put(v[0], map.getOrDefault(v[0], 0) + v[1]);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey(), v = entry.getValue();
            List<Integer> pair = new ArrayList<>();
            pair.add(k);
            pair.add(v);
            res.add(pair);
        }
        res.sort(Comparator.comparingInt(a -> a.get(0)));
        return res;
    }
}
