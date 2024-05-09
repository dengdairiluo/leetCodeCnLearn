package com.yuren.leetcodecnlearn.Q2400;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-09 下午11:29
 */
public class Q2404 {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : nums) {
            if (x % 2 == 0) {
                count.put(x, count.getOrDefault(x, 0) + 1);
            }
        }
        int res = -1, ct = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (res == -1 || entry.getValue() > ct || entry.getValue() == ct && res > entry.getKey()) {
                res = entry.getKey();
                ct = entry.getValue();
            }
        }
        return res;
    }
}
