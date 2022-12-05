package com.yuren.leetcodecnlearn.Q100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q49 {

    private static final int[] arr = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<Double, ArrayList<String>> map = new HashMap<>();


        for (String str : strs) {
            char[] chs = str.toCharArray();
            double sum = 1.0;
            for (char ch : chs) {
                sum *= arr[(ch - 'a')];
            }
            if (!map.containsKey(sum)) map.put(sum, new ArrayList<>());
            map.get(sum).add(str);
        }
        return new ArrayList<>(map.values());
    }


}
