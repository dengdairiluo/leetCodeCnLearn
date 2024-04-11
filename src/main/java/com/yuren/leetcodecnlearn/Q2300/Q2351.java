package com.yuren.leetcodecnlearn.Q2300;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-11 下午11:41
 */
public class Q2351 {
    public char repeatedCharacter(String s) {
        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!seen.add(ch)) {
                return ch;
            }
        }
        // impossible
        return ' ';
    }
}
