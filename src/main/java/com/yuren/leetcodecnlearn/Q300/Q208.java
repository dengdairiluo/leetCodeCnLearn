package com.yuren.leetcodecnlearn.Q300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-10-13 22:26
 */
public class Q208 {
    Node root;

    /**
     * Initialize your data structure here.
     */
    public Q208() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        int len = word.length();
        Node curr = root;
        for (int i = 0; i < len; ++i) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }
        // curr到单词末端了 做好标记 目的是什么？是防止越界嘛？
        curr.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node lastNode = prefixExists(word);
        if (lastNode == null) {
            // prefix(word)
            return false;
        }
        return lastNode.isEnd;

    }

    // 存在 则返回最后一个Node 不存在 则返回null
    private Node prefixExists(String prefix) {
        Node curr = root;
        int len = prefix.length();
        for (int i = 0; i < len; ++i) {
            if (curr == null) return null;
            curr = curr.children[prefix.charAt(i) - 'a'];
        }
        return curr;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node lastNode = prefixExists(prefix);
        return lastNode != null;
        // 前缀判断 只要有就行 包括前缀本身
    }

    private static class Node {
        // 或者使用List替代 省点空间？
        // 但我觉得一般应用场景 单词是足够多的 基本充满每个节点的26个字母
        Node[] children = new Node[26];
        boolean isEnd = false;
    }
}
