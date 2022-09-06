package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-06 23:46
 */
public class Q979 {
    int ans;

    public int distributeCoins(TreeNode root) {
        ans = 0;
        this.find(root);
        return ans;
    }

    private int find(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int cur = root.val;
        int left = this.find(root.left);
        int right = this.find(root.right);
        int sum = cur + left + right - 1;
        ans += Math.abs(sum);
        return sum;
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
