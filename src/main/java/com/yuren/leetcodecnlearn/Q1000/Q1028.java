package com.yuren.leetcodecnlearn.Q1000;

import java.util.Deque;
import java.util.LinkedList;

public class Q1028 {
    public TreeNode recoverFromPreorder1(String traversal) {
        Deque<TreeNode> path = new LinkedList<>();
        int pos = 0;
        while (pos < traversal.length()) {
            int level = 0;
            while (traversal.charAt(pos) == '-') {
                ++level;
                ++pos;
            }
            int value = 0;
            while (pos < traversal.length() && Character.isDigit(traversal.charAt(pos))) {
                value = value * 10 + (traversal.charAt(pos) - '0');
                ++pos;
            }
            TreeNode node = new TreeNode(value);
            if (level == path.size()) {
                if (!path.isEmpty()) {
                    path.peek().left = node;
                }
            } else {
                while (level != path.size()) {
                    path.pop();
                }
                path.peek().right = node;
            }
            path.push(node);
        }
        while (path.size() > 1) {
            path.pop();
        }
        return path.peek();

    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
