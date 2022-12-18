package com.yuren.leetcodecnlearn.Q1100;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-10 23:54
 */
public class Q1065 {
    List<int[]> res = new ArrayList<>();

    public int[][] indexPairs(String text, String[] words) {
        Trie t = new Trie();
        for (String w : words) {
            t.insert(w);
        }
        for (int i = 0; i < text.length(); i++) {
            t.search(text, i, res);
        }
        int[][] arr = new int[res.size()][2];
        IntStream.range(0, res.size()).forEach(i -> arr[i] = res.get(i));
        return arr;
    }

    static class Trie {
        private Trie[] children;
        private boolean isEnd;
        private int val;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
            val = 0;
        }

        public void insert(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
            node.val++;
        }

        private Trie searchPrefix(String prefix) {
            Trie node = this;
            for (char c : prefix.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }

            return node;
        }

        public void search(String word, int start, List<int[]> res) {
            Trie node = this;
            for (int i = start; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null) {
                    break;
                }
                node = node.children[index];
                if (node.isEnd) {
                    res.add(new int[]{start, i});
                }
            }
        }

        public boolean exist(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;

        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        public int count(String word) {
            Trie node = searchPrefix(word);
            if (node == null) {
                return 0;
            } else {
                return node.val;
            }
        }
    }
}
