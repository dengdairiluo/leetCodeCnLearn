package com.yuren.leetcodecnlearn.Q2200;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-14 22:03
 */
public class Q2295 {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Map<Integer, Integer> demo = new HashMap<>();

        for (int[] op : operations) {
            if (map.containsKey(op[0])) {
                demo.put(op[1], map.get(op[0]));
                map.remove(op[0]);
            } else {
                demo.put(op[1], demo.get(op[0]));
                demo.remove(op[0]);
            }
        }
        int[] ans = new int[nums.length];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans[entry.getValue()] = entry.getKey();
        }
        for (Map.Entry<Integer, Integer> entry : demo.entrySet()) {
            ans[entry.getValue()] = entry.getKey();
        }
        return ans;
    }
}
