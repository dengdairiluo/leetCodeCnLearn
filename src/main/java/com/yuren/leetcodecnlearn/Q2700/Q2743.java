package com.yuren.leetcodecnlearn.Q2700;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-26 20:58
 */
public class Q2743 {
    public int numberOfSpecialSubstrings(String s) {
        Map<Character, Integer> indices = new HashMap<>();
        int specialSubstrings = 0;
        int start = 0, end = 0;
        int length = s.length();
        while (end < length) {
            char c = s.charAt(end);
            int index = indices.getOrDefault(c, -1);
            start = Math.max(start, index + 1);
            specialSubstrings += end - start + 1;
            indices.put(c, end);
            end++;
        }
        return specialSubstrings;
    }
}
