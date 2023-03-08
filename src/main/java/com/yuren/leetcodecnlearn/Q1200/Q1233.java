package com.yuren.leetcodecnlearn.Q1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-25 02:32
 */
public class Q1233 {
    private static class FolderTrieNode {
        char val;
        boolean isEnd;
        FolderTrieNode[] children = new FolderTrieNode[27];

        public FolderTrieNode() {
        }
    }

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, Comparator.comparingInt(String::length));
        FolderTrieNode root = new FolderTrieNode();
        root.val = '/';
        List<String> ans = new ArrayList<>();
        for (String str : folder) {
            this.addSubfolders(str, root, ans);
        }
        return ans;
    }

    public void addSubfolders(String str, FolderTrieNode node, List<String> ans) {
        int len = str.length();
        for (int i = 1; i < len; i++) {
            char c = str.charAt(i);
            FolderTrieNode tempNode = c == '/' ? node.children[26] : node.children[c - 'a'];
            if (tempNode == null) {
                tempNode = new FolderTrieNode();
                tempNode.val = c;
                node.children[c == '/' ? 26 : c - 'a'] = tempNode;
            } else {
                if (tempNode.isEnd && i < len - 1 && str.charAt(i + 1) == '/') {
                    return;
                }
            }
            if (len - 1 == i) {
                tempNode.isEnd = true;
                ans.add(str);
            } else {
                node = tempNode;
            }
        }
    }
}
