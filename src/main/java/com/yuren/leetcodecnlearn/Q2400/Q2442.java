package com.yuren.leetcodecnlearn.Q2400;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-28 下午11:06
 */
public class Q2442 {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            if (num >= 10) {
                int x = num, n = 0;
                while (x != 0) {
                    n = n * 10 + x % 10;
                    x /= 10;
                }
                set.add(n);
            }
        }
        return set.size();
    }
}
