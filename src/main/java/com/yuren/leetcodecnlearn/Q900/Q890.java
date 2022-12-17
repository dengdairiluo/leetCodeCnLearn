package com.yuren.leetcodecnlearn.Q900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-08-04 22:23
 */
public class Q890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> res = new ArrayList<>();

        for (String word : words) {
            if (match(word, pattern)) {
                res.add(word);
            }
        }

        return res;
    }

    public boolean match(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map.containsKey(c1) && map.get(c1) != c2) {
                return false;
            }

            if (map2.containsKey(c2) && map2.get(c2) != c1) {
                return false;
            }

            map.putIfAbsent(c1, c2);
            map2.putIfAbsent(c2, c1);
        }

        return true;
    }

}
