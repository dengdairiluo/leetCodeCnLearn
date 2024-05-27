package com.yuren.leetcodecnlearn.Q2400;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-27 下午11:58
 */
public class Q2441 {
    public int findMaxK(int[] nums) {
        int ans = -1;
        Set<Integer> s = new HashSet<>();
        for (int x : nums) {
            if (s.contains(-x))
                ans = Math.max(ans, Math.abs(x));
            s.add(x);
        }
        return ans;
    }
}
