package com.yuren.leetcodecnlearn.Q700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-22 22:57
 */
public class Q671 {
    Integer ans;
    int min;

    public int findSecondMinimumValue(TreeNode root) {
        ans = null;
        min = root.val;
        this.secondMinimumValue(root);
        return ans == null ? -1 : ans;
    }

    private void secondMinimumValue(TreeNode root) {
        if (root == null) {
            return;
        }
        if (ans == null) {
            if (root.val > min) {
                ans = root.val;
            }
        } else {
            if (root.val > min && root.val < ans) {
                ans = root.val;
            }
        }
        this.secondMinimumValue(root.left);
        this.secondMinimumValue(root.right);
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
