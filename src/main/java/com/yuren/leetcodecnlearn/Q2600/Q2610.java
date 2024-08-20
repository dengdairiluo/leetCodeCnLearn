package com.yuren.leetcodecnlearn.Q2600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-20 23:55
 */
public class Q2610 {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> arr2d = new ArrayList<>();
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            int index = counts.getOrDefault(num, 0);
            counts.put(num, index + 1);
            if (arr2d.size() == index) {
                arr2d.add(new ArrayList<>());
            }
            arr2d.get(index).add(num);
        }
        return arr2d;
    }
}
