package com.yuren.leetcodecnlearn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-03-26 22:03
 */
public class Q1436 {

    private static String destCity1(List<List<String>> paths) {
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        for (List<String> path : paths) {
            startSet.add(path.get(0));
            endSet.add(path.get(1));
        }

        for (String end : endSet) {
            if (!startSet.contains(end)) {
                return end;
            }
        }
        return null;
    }

    private static String destCity(List<List<String>> paths) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (List<String> path : paths) {
            hashMap.put(path.get(0), path.get(1));
        }
        String key = paths.get(0).get(0);
        while (hashMap.containsKey(key)) {
            key = hashMap.get(key);
        }
        return key;
    }
}
