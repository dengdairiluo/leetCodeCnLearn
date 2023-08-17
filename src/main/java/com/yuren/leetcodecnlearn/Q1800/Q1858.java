package com.yuren.leetcodecnlearn.Q1800;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-17 23:40
 */
public class Q1858 {
    private static class Node {
        Map<Character, Node> children;
        boolean isEnd;

        Node() {
            children = new HashMap<>();
            isEnd = false;
        }
    }

    public String longestWord(String[] words) {
        if (words.length == 1) return words[0];
        Arrays.sort(words, (a, b) -> {
            if (a.length() == b.length()) return a.compareTo(b);
            return a.length() - b.length();
        });
        String res = "";
        Node root = new Node();
        for (String word : words) {
            Node cur = root;
            boolean canBeResult = true;
            char[] chars = word.toCharArray();
            int i = 0;
            for (; i < chars.length - 1; i++) {
                if (!cur.children.containsKey(chars[i])) {
                    canBeResult = false;
                    cur.children.put(chars[i], new Node());
                }
                cur = cur.children.get(chars[i]);
                if (!cur.isEnd) canBeResult = false;
            }
            cur.children.put(chars[i], new Node());
            cur.children.get(chars[i]).isEnd = true;
            if (canBeResult && word.length() > res.length()) {
                res = word;
            }
        }
        return res;
    }
}
