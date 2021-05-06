package com.yuren.leetcodecnlearn;

import java.util.*;

public class Q1207 {
    public boolean uniqueOccurrences1(int[] arr) {
        int count = 0;
        int sum = 1;
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                sum += 1;
            } else {
                ++count;
                map.put(sum, 0);
                sum = 1;
            }
        }
        ++count;
        map.put(sum, 0);
        return count == map.size();
    }

    public boolean uniqueOccurrences2(int[] arr) {
        int count = 0;
        int sum = 1;
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                sum += 1;
            } else {
                ++count;
                set.add(sum);
                sum = 1;
            }
        }
        ++count;
        set.add(sum);
        return count == set.size();
    }
}
