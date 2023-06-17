package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-17 23:23
 */
public class Q1698 {
    private static class TrieNode {
        public TrieNode[] next;

        public TrieNode() {
            next = new TrieNode[26];
        }
    }

    public int countDistinct(String s) {
        int res = 0;
        int n = s.length();
        TrieNode root = new TrieNode();
        for (int i = 0; i < n; i++) {
            TrieNode cur = root;
            for (int j = i; j < n; j++) {
                int index = s.charAt(j) - 'a';
                if (cur.next[index] == null) {
                    cur.next[index] = new TrieNode();
                    res += 1;
                }
                cur = cur.next[index];
            }
        }
        return res;
    }
}
