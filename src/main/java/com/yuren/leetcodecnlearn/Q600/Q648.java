package com.yuren.leetcodecnlearn.Q600;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-13 23:17
 */
public class Q648 {
    private static class TrieNode {
        TrieNode[] children;
        String word;

        TrieNode() {
            children = new TrieNode[26];
        }
    }

    class Solution {
        public String replaceWords(List<String> roots, String sentence) {
            TrieNode trie = new TrieNode();
            for (String root : roots) {
                TrieNode cur = trie;
                for (char letter : root.toCharArray()) {
                    if (cur.children[letter - 'a'] == null)
                        cur.children[letter - 'a'] = new TrieNode();
                    cur = cur.children[letter - 'a'];
                }
                cur.word = root;
            }

            StringBuilder ans = new StringBuilder();

            for (String word : sentence.split("\\s+")) {
                if (ans.length() > 0)
                    ans.append(" ");

                TrieNode cur = trie;
                for (char letter : word.toCharArray()) {
                    if (cur.children[letter - 'a'] == null || cur.word != null)
                        break;
                    cur = cur.children[letter - 'a'];
                }
                ans.append(cur.word != null ? cur.word : word);
            }
            return ans.toString();
        }
    }
}
