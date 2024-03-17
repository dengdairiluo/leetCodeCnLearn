package com.yuren.leetcodecnlearn.Q2300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-17 22:43
 */
public class Q2301 {
    int n, m;
    Map<Character, Set<Character>> map;

    public boolean match(String s, String t) {
        for (int i = 1; i < m; i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (sc != tc && !map.getOrDefault(tc, new HashSet<>()).contains(sc)) {
                return false;
            }
        }
        return true;
    }

    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        n = s.length();
        m = sub.length();
        if (n < m) {
            return false;
        }
        map = new HashMap<>();
        for (char[] ch : mappings) {
            Set<Character> set = map.get(ch[0]);
            if (set == null) {
                set = new HashSet<>();
                map.put(ch[0], set);
            }
            set.add(ch[1]);
        }
        char start = sub.charAt(0);
        Set<Character> rs = map.getOrDefault(start, new HashSet<>());
        for (int i = 0; i < n - m + 1; i++) {
            char c = s.charAt(i);
            if (c == start || rs.contains(c)) {
                if (match(s.substring(i, i + m), sub)) {
                    return true;
                }
            }
        }
        return false;
    }
}
