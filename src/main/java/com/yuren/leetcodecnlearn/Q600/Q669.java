package com.yuren.leetcodecnlearn.Q600;

public class Q669 {
    public TreeNode trimBst(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val > R) return trimBst(root.left, L, R);
        if (root.val < L) return trimBst(root.right, L, R);

        root.left = trimBst(root.left, L, R);
        root.right = trimBst(root.right, L, R);
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
