package com.yuren.leetcodecnlearn.Q200;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-10-04 21:49
 */
public class Q170 {
    private final Set<Integer> all;
    private final Set<Integer> duplicate;

    /**
     * Initialize your data structure here.
     */
    public Q170() {
        all = new HashSet<>();
        duplicate = new HashSet<>();
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        if (all.contains(number)) {
            duplicate.add(number);
        } else {
            all.add(number);
        }
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        int target;
        for (int num : all) {
            target = value - num;
            if (target == num && duplicate.contains(target)) {
                return true;
            }
            if (target != num && all.contains(target)) {
                return true;
            }
        }
        return false;
    }
}
