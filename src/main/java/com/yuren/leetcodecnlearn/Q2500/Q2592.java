package com.yuren.leetcodecnlearn.Q2500;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-11 22:26
 */
public class Q2592 {
    public int maximizeGreatness(int[] nums) {
        int mx = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums)
            mx = Math.max(mx, cnt.merge(x, 1, Integer::sum));
        return nums.length - mx;
    }
}
