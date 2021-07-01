package com.yuren.leetcodecnlearn;

import java.util.HashMap;
import java.util.Map;

public class MST1602 {
    private Map<String, Integer> map = new HashMap<>();

    public MST1602(String[] book) {
        for (String word : book) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
    }

    public int get1(String word) {
        return map.getOrDefault(word, 0);
    }
}
