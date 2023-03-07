package com.yuren.leetcodecnlearn.Q500;

public class Q536 {
    private static int buildSubTree(TreeNode node, String string, int index) {
        int i = index;
        while ((string.charAt(i) >= '0' && string.charAt(i) <= '9') || string.charAt(i) == '-') {
            i++;
            if (i >= string.length()) {
                break;
            }
        }
        node.val = Integer.parseInt(string.substring(index, i));
        if (i < string.length() && string.charAt(i) == '(') {
            node.left = new TreeNode(0);
            i = buildSubTree(node.left, string, i + 1);
        }
        if (i < string.length() && string.charAt(i) == '(') {
            node.right = new TreeNode(0);
            i = buildSubTree(node.right, string, i + 1);
        }
        if (i < string.length() && string.charAt(i) == ')') {
            return ++i;
        }
        return i;
    }

    public TreeNode str2tree(String s) {
        if (s == null || s.length() < 1) {
            return null;
        }
        TreeNode node = new TreeNode(0);
        buildSubTree(node, s, 0);
        return node;
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
