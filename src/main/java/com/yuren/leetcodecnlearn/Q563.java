package com.yuren.leetcodecnlearn;

public class Q563 {
    private int ans;

    public int findTilt(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int l = dfs(node.left), r = dfs(node.right);
        ans += Math.abs(r - l);
        return l + r + node.val;
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
