package com.yuren.leetcodecnlearn.Q2400;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-08 下午11:57
 */
public class Q2465 {
    public int distinctAverages(int[] nums) {
        int[] count = new int[101];
        for (int i : nums) {
            count[i]++;
        }
        int l = 0, r = 100;
        Set<Double> set = new HashSet<>();
        while (l <= r) {
            if (count[l] == 0) {
                l++;
                continue;
            }
            if (count[r] == 0) {
                r--;
                continue;
            }
            set.add((l + r) * 1.0 / 2);
            count[l]--;
            count[r]--;
        }
        return set.size();
    }
}
