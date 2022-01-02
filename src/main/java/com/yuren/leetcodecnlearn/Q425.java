package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-01-02 23:04
 */
public class Q425 {
    public List<List<String>> wordSquares(String[] words) {
        int n = words[0].length();
        Trie trie = new Trie();
        for (String word : words)
            trie.insert(word, n);

        List<List<String>> result = new LinkedList<>();
        String[] finished = new String[n];
        char[][] board = new char[n][n];

        search(trie.root, trie.root, board, 0, 0, n, finished, result);

        return result;
    }

    /**
     * current：当前搜索节点
     * root：根节点
     * board：字符矩阵
     * i：正要处理的行（第几个单词）
     * j：正要处理的列（第几个字符）
     * n：单词长度（矩阵宽度）
     * finished：已经填好的单词（0 ~ i-1 已经填好）
     * result：输出结果
     */
    private void search(TrieNode current, TrieNode root, char[][] board, int i, int j, int n, String[] finished, List<List<String>> result) {

        // 全部n个单词填好，输出结果
        if (i == n) {
            result.add(new ArrayList<>(Arrays.asList(finished)));
            return;
        }

        // 第i个单词填好，放入finished
        if (j == n) {
            finished[i] = current.word;
            search(root, root, board, i + 1, 0, n, finished, result);
            return;
        }

        // 之前已经填过的格子，检查是否可以找到
        // 比如在填第一个单词wall时，(0, 1) 处字符填了a，同时在(1, 0)处也填了a
        // 那么在处理第二个单词时，先要看第一个字符（也就是 i = 0, j = 1 处是否可以为a
        // 如果不能为 a，结束该搜索过程，回溯
        if (j < i) {
            TrieNode child = current.getChild(board[i][j]);
            if (child != null) {
                search(child, root, board, i, j + 1, n, finished, result);
            }
            return;
        }

        // 尝试在该点添堵所有可能的字符
        for (int c = 0; c < 26; ++c) {
            if (current.children[c] != null) {
                // 如果在填第一个单词时，同时可以判断每个字符是否可以作为起始字符，从而减少递归分支
                if (i == 0 && root.children[c] == null) {
                    continue;
                }
                board[j][i] = board[i][j] = (char) ('a' + c);
                search(current.children[c], root, board, i, j + 1, n, finished, result);
            }
        }
    }


    private static class Trie {
        public TrieNode root = new TrieNode();

        public void insert(String word, int n) {
            TrieNode node = root;
            int charNo;
            for (int i = 0; i < n; ++i) {
                charNo = word.charAt(i) - 'a';
                if (node.children[charNo] == null) {
                    node.children[charNo] = new TrieNode();
                }
                node = node.children[charNo];
            }
            node.word = word;
        }
    }

    private static class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String word = null;

        public TrieNode getChild(char c) {
            return children[c - 'a'];
        }
    }

}
