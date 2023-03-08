package com.yuren.leetcodecnlearn.Q1500;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q1577 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> endSet = new HashSet<>();
        for (List<Integer> edge : edges) {
            endSet.add(edge.get(1));
        }
        for (int i = 0; i < n; i++) {
            if (!endSet.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
