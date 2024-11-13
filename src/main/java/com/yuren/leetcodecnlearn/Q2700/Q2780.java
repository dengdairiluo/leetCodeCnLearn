package com.yuren.leetcodecnlearn.Q2700;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-11-13 23:45
 */
public class Q2780 {
    public int minimumIndex(List<Integer> nums) {
        int dominant = getDominant(nums);
        int count = 0;
        for (int num : nums) {
            if (num == dominant) {
                count++;
            }
        }
        int countLeft = 0, countRight = count;
        int n = nums.size();
        for (int i = 0, sizeLeft = 1, sizeRight = n - 1; i < n; i++, sizeLeft++, sizeRight--) {
            int num = nums.get(i);
            if (num == dominant) {
                countLeft++;
                countRight--;
            }
            if (countLeft * 2 > sizeLeft && countRight * 2 > sizeRight) {
                return i;
            }
        }
        return -1;
    }

    public int getDominant(List<Integer> nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        int dominant = 0;
        int n = nums.size();
        Set<Map.Entry<Integer, Integer>> entries = counts.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() * 2 > n) {
                dominant = entry.getKey();
                break;
            }
        }
        return dominant;
    }
}
