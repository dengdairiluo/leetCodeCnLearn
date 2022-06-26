package com.yuren.leetcodecnlearn;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-07-17 21:16
 */
public class Q820 {
    public boolean xorGame(int[] nums) {
        if (nums.length % 2 == 0) {
            return true;
        }
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor == 0;

    }

    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        int ans = 0;
        Trie trie = new Trie();
        for (String word : words) {
            ans += trie.insert(word);
        }
        return ans;
    }

    private static class Trie {
        Trie[] children;
        boolean isWord;

        public Trie() {
            this.children = new Trie[26];
            this.isWord = false;
        }

        /**
         * 倒着插入新的单词，返回本次插入对有效编码长度的贡献
         *
         * @param word
         * @return
         */
        public int insert(String word) {
            Trie node = this;
            boolean isNew = false;
            for (int i = word.length() - 1; i >= 0; i--) {
                int idx = word.charAt(i) - 'a';
                if (node.children[idx] == null) {
                    // 是新单词
                    isNew = true;
                    node.children[idx] = new Trie();
                }
                node = node.children[idx];
            }
            node.isWord = true;
            return isNew ? word.length() + 1 : 0;
        }
    }
}
