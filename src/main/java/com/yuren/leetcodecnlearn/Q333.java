package com.yuren.leetcodecnlearn;

public class Q333 {

    public int largestBSTSubtree(TreeNode root) {
        Result r = visit(root);
        return r == null ? 0 : r.size;
    }

    public Result visit(TreeNode node) {
        if (node == null) {
            return null;
        }

        Result l = null, r = null;
        if (node.left != null) {
            l = visit(node.left);
        }
        if (node.right != null) {
            r = visit(node.right);
        }

        // 当前树为BST
        boolean lValid = (l == null || (l.node == node.left && l.max < node.val));
        boolean rValid = (r == null || (r.node == node.right && r.min > node.val));
        if (lValid && rValid) {
            Result result = new Result();
            result.node = node;
            result.max = r == null ? node.val : r.max;
            result.min = l == null ? node.val : l.min;
            result.size = (l == null ? 0 : l.size) + (r == null ? 0 : r.size) + 1;
            return result;
        }

        // 左右子树中找到了BST
        if (l != null && r != null) {
            return l.size > r.size ? l : r;
        }
        if (l != null) {
            return l;
        }
        return r;
    }

    private static class Result {
        TreeNode node; // BST根节点
        int size; // BST的size
        int max; // BST的最大值
        int min; // BST的最小值
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
