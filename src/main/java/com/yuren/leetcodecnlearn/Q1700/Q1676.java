package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-07-04 23:01
 */
public class Q1676 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if (root == null) {
            return null;
        }

        if (isIn(nodes, root)) {
            return root;
        } else {
            TreeNode res = null;
            TreeNode left = lowestCommonAncestor(root.left, nodes);
            TreeNode right = lowestCommonAncestor(root.right, nodes);
            if (left != null && right != null) {
                return root;
            }
            res = (left == null) ? right : left;
            return res;
        }

    }

    public boolean isIn(TreeNode[] nodes, TreeNode root) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == root) {
                return true;
            }
        }
        return false;
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
