package com.yuren.leetcodecnlearn.Q2400;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-02 下午11:47
 */
public class Q2453 {
    public int destroyTargets(int[] nums, int space) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int v : nums) map.put(v % space, map.getOrDefault(v % space, 0) + 1);
        int tot = 0, ans = Integer.MAX_VALUE;

        for (int i : nums) {
            int have = map.get(i % space);
            if (tot == have) {
                ans = Math.min(ans, i);
            } else if (tot < have) {
                tot = have;
                ans = i;
            }
        }
        return ans;
    }
}
