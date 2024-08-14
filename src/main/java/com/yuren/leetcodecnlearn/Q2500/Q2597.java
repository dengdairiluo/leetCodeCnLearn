package com.yuren.leetcodecnlearn.Q2500;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-15 01:11
 */
public class Q2597 {
    int subsets = 0;
    Map<Integer, Integer> counts = new HashMap<>();
    int[] nums;
    int n;
    int k;

    public int beautifulSubsets(int[] nums, int k) {
        this.nums = nums;
        this.n = nums.length;
        this.k = k;
        backtrack(0);
        return subsets;
    }

    public void backtrack(int index) {
        if (index == n) {
            if (!counts.isEmpty()) {
                subsets++;
            }
        } else {
            backtrack(index + 1);
            int num = nums[index];
            if (!counts.containsKey(num - k) && !counts.containsKey(num + k)) {
                counts.put(num, counts.getOrDefault(num, 0) + 1);
                backtrack(index + 1);
                counts.put(num, counts.get(num) - 1);
                if (counts.get(num) == 0) {
                    counts.remove(num);
                }
            }
        }
    }

}
