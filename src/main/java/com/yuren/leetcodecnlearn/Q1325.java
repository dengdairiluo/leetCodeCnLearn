package com.yuren.leetcodecnlearn;

public class Q1325 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root;
        removeLeafNodes(root.left, target);
        removeLeafNodes(root.right, target);
        if (root.left != null && root.left.left == null && root.left.right == null && root.left.val == target) {
            root.left = null;
        }
        if (root.right != null && root.right.left == null && root.right.right == null && root.right.val == target) {
            root.right = null;
        }
        if (root.val == target && root.left == null && root.right == null) {
            root = null;
        }
        return root;

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
