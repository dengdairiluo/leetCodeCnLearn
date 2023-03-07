package com.yuren.leetcodecnlearn.Q200;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-11-13 23:40
 */
public class Q291 {
    public boolean wordPatternMatch(String pattern, String s) {
        Map<Character, Integer> countTable = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            int count = countTable.getOrDefault(pattern.charAt(i), 0);
            count++;
            countTable.put(pattern.charAt(i), count);
        }
        return back(0, 0, pattern, s, countTable, new HashMap<>(), new HashMap<>());
    }

    private boolean back(int idx, int start, String pattern, String s, Map<Character, Integer> countTable,
                         Map<Character, String> cToStr, Map<String, Character> strToC) {
        if (idx == pattern.length() || start >= s.length()) {
            return idx == pattern.length() && start == s.length();
        }
        char curChar = pattern.charAt(idx);
        if (cToStr.containsKey(curChar)) {
            String candidate = s.substring(start, Math.min(start + cToStr.get(curChar).length(), s.length()));
            if (candidate.equals(cToStr.get(curChar))) {
                return back(idx + 1, start + cToStr.get(curChar).length(), pattern, s, countTable,
                        cToStr, strToC);
            }
            return false;
        }
        int limit = (s.length() - countTable.keySet().size() + 1) / countTable.get(curChar);
        for (int len = 1; len <= limit; len++) {
            String candidate = s.substring(start, Math.min(start + len, s.length()));
            if (strToC.containsKey(candidate)) {// ab->aa
                continue;
            }
            cToStr.put(curChar, candidate);
            strToC.put(candidate, curChar);
            if (back(idx + 1, start + len, pattern, s, countTable, cToStr, strToC)) {
                return true;
            }
            cToStr.remove(curChar);
            strToC.remove(candidate);
        }
        return false;
    }
}
