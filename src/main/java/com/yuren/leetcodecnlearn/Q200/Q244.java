package com.yuren.leetcodecnlearn.Q200;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-10-25 22:45
 */
public class Q244 {
    private final HashMap<String, ArrayList<Integer>> map;

    public Q244(String[] wordsDict) {
        map = new HashMap<>();
        int i = 0;
        for (String word : wordsDict) {
            ArrayList<Integer> list = map.get(word);
            if (list == null) {
                list = new ArrayList<>();
                map.put(word, list);
            }
            list.add(i);
            i++;
        }
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> list1 = map.get(word1);
        ArrayList<Integer> list2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        int ptr1 = 0;
        int ptr2 = 0;
        int prev = Integer.MAX_VALUE / 2;
        int current;
        while (ptr1 < list1.size() && ptr2 < list2.size()) {
            if (list1.get(ptr1) < list2.get(ptr2)) {
                current = list1.get(ptr1++) + 1;
            } else {
                current = -list2.get(ptr2++) - 1;
            }
            if (current < 0 && prev > 0 || current > 0 && prev < 0) {
                min = Math.min(min, Math.abs(current + prev));
            }
            prev = current;
        }
        if (ptr1 < list1.size()) {
            current = list1.get(ptr1) + 1;
        } else {
            current = -list2.get(ptr2) - 1;
        }
        if (current < 0 && prev > 0 || current > 0 && prev < 0) {
            min = Math.min(min, Math.abs(current + prev));
        }
        return min;
    }
}
