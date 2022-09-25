package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-25 23:36
 */
public class Q1032 {
    //字典树，将words中每个字符串反向添加到字典树中
    //然后用一个list保存接收的字符
    Node root = new Node();
    List<Character> list = new ArrayList<>();

    public Q1032(String[] words) {
        for (String word : words) {
            insertReverse(word);
        }
    }

    public boolean query(char letter) {
        list.add(letter);
        Node node = root;
        //从后往前判断
        for (int i = list.size() - 1; i >= 0; i--) {
            int index = list.get(i) - 'a';
            if (node.children[index] == null) {
                return false;
            } else if (node.children[index].isEnd) {
                return true;
            }
            node = node.children[index];
        }
        return node.isEnd;
    }

    /**
     * 反向添加字符串
     *
     * @param word
     */
    private void insertReverse(String word) {
        Node node = root;
        char[] cs = word.toCharArray();
        for (int i = cs.length - 1; i >= 0; i--) {
            int index = cs[i] - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Node();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    private static class Node {
        boolean isEnd;
        Node[] children = new Node[26];
    }
}
