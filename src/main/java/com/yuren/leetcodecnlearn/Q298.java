package com.yuren.leetcodecnlearn;

public class Q298 {

    int result = 1;

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return result;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 记录左孩子的最长路径
        int left = helper(root.left);
        // 记录右孩子的最长路径
        int right = helper(root.right);
        // 保存当前节点最长路径
        int cur = 1;
        int add = 0;
        if (root.left != null && root.val == root.left.val - 1) {
            // 如果左孩子等于根节点+1
            add = left;
        }
        if (root.right != null && root.val == root.right.val - 1) {
            // 获取当前节点应该加上的孩子最长路径
            add = Math.max(add, right);
        }
        cur += add;
        // 获取较大的路径
        result = Math.max(result, cur);
        return cur;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
