package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-10-28 22:52
 */
public class Q250 {
    private int ansCount = 0;

    private boolean isSame(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean isLeftOk = root.left == null || isSame(root.left) && root.val == root.left.val;

        boolean isRightOk = root.right == null || isSame(root.right) && root.val == root.right.val;

        if (isLeftOk && isRightOk) {
            ansCount++;
            return true;
        }

        return false;
    }

    public int countUnivalSubtrees(TreeNode root) {
        isSame(root);
        return ansCount;
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
