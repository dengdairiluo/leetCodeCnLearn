package com.yuren.leetcodecnlearn.Q2500;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-31 上午12:46
 */
public class Q2568 {
    public int minImpossibleOR(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int x : nums) s.add(x);
        for (int i = 1; ; i <<= 1)
            if (!s.contains(i))
                return i;
    }
}
