package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-21 23:50
 */
public class Q951 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                boolean ans1 = this.flipEquiv(root1.left, root2.left) && this.flipEquiv(root1.right, root2.right);
                if (ans1) {
                    return true;
                }
                return this.flipEquiv(root1.left, root2.right) && this.flipEquiv(root1.right, root2.left);
            }
        }
        return false;
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
