package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-03-13 22:14
 */
public class Q1315 {

    public int sumEvenGrandparent(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return ans;
        }

        if (root.val % 2 == 0) {
            if (root.left != null) {
                if (root.left.left != null) {
                    ans += root.left.left.val;
                }
                if (root.left.right != null) {
                    ans += root.left.right.val;
                }
            }
            if (root.right != null) {
                if (root.right.left != null) {
                    ans += root.right.left.val;
                }
                if (root.right.right != null) {
                    ans += root.right.right.val;
                }
            }
        }
        return ans + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
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
