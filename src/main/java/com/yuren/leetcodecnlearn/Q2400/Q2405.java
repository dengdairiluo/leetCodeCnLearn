package com.yuren.leetcodecnlearn.Q2400;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-09 下午11:29
 */
public class Q2405 {
    public int partitionString(String s) {
        int count = 1;
        Set<Character> set = new HashSet<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                count++;
                set.clear();
            }
            set.add(c);
        }
        return count;
    }
}
