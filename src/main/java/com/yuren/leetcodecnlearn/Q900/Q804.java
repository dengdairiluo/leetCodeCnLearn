package com.yuren.leetcodecnlearn.Q900;

import java.util.HashSet;
import java.util.Set;

public class Q804 {

    private static final String[] map = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.."
    };

    public int uniqueMorseRepresentations(String[] words) {
        if (words == null) return 0;
        Set<String> set = new HashSet<>();
        for (String s : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                sb.append(map[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
