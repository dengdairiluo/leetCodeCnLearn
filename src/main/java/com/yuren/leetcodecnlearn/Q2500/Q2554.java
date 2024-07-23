package com.yuren.leetcodecnlearn.Q2500;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-23 下午11:48
 */
public class Q2554 {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            bannedSet.add(num);
        }
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (bannedSet.contains(i)) {
                continue;
            }
            if (sum + i > maxSum) {
                break;
            }
            sum += i;
            count++;
        }
        return count;
    }
}
