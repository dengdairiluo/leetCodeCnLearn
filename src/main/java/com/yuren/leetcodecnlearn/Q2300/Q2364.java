package com.yuren.leetcodecnlearn.Q2300;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-19 下午11:05
 */
public class Q2364 {
    public long countBadPairs(int[] nums) {
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = i - nums[i];
            int same = map.getOrDefault(val, 0);
            ans += i - same;
            map.put(val, same + 1);
        }
        return ans;
    }

}
