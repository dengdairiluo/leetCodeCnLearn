package com.yuren.leetcodecnlearn.Q900;

public class Q938 {
    private static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        if (root.val >= low && root.val <= high) {
            //当前节点再两数之间，把自身值加到结果里取，并往左右子节点递归
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        } else if (root.val < low) {
            //当前节点小于low，往右子节点寻找
            return rangeSumBST(root.right, low, high);
        } else {
            //当前节点大于high，往左子节点寻找
            return rangeSumBST(root.left, low, high);
        }
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
