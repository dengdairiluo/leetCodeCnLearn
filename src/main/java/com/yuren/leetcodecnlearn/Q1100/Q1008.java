package com.yuren.leetcodecnlearn.Q1100;

public class Q1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length - 1);
    }

    public TreeNode build(int[] preorder, int i, int j) {
        if (j < i) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[i]);
        int k = i + 1;
        while (k <= j) {
            if (preorder[k] > preorder[i]) {
                break;
            }
            k++;
        }
        root.left = build(preorder, i + 1, k - 1);
        root.right = build(preorder, k, j);
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
