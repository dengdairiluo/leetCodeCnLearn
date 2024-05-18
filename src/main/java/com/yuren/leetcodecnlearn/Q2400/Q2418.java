package com.yuren.leetcodecnlearn.Q2400;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-18 下午11:32
 */
public class Q2418 {
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], names[i]);
        }
        return map.values().toArray(new String[names.length]);

    }
}
