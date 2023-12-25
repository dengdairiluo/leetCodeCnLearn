package com.yuren.leetcodecnlearn.Q2100;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-25 22:42
 */
public class Q2135 {
    public int wordCount(String[] startWords, String[] targetWords) {
        Map<Integer, Boolean> has = new HashMap<>();
        for (String s : startWords) {
            int mask = 0;
            for (int i = 0; i < s.length(); i++) {
                mask |= 1 << (s.charAt(i) - 'a');
            }
            has.put(mask, true);
        }
        int res = 0;
        for (String s : targetWords) {
            int mask = 0;
            for (int i = 0; i < s.length(); i++) {
                mask |= 1 << (s.charAt(i) - 'a');
            }
            for (int i = 0; i < s.length(); i++) {
                if (has.containsKey(mask ^ (1 << (s.charAt(i) - 'a')))) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
