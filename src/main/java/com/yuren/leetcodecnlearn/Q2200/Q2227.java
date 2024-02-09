package com.yuren.leetcodecnlearn.Q2200;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-09 23:44
 */
public class Q2227 {
    String[] map = new String[26];
    Map<String, Integer> cnt = new HashMap<>();

    public Q2227(char[] keys, String[] values, String[] dictionary) {
        for (int i = 0; i < keys.length; i++)
            map[keys[i] - 'a'] = values[i];
        for (String s : dictionary) {
            String e = encrypt(s);
            cnt.put(e, cnt.getOrDefault(e, 0) + 1);
        }
    }

    public String encrypt(String word1) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < word1.length(); i++) {
            String s = map[word1.charAt(i) - 'a'];
            if (s == null) return "";
            res.append(s);
        }
        return res.toString();
    }

    public int decrypt(String word2) {
        return cnt.getOrDefault(word2, 0);
    }
}
