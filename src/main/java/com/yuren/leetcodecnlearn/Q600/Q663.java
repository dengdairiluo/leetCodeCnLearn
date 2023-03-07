package com.yuren.leetcodecnlearn.Q600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-18 23:47
 */
public class Q663 {
    public boolean checkEqualTree(TreeNode root) {
        // 返回根节点的和
        int sum = postOrder(root);
        // 看左子树和右子树是否满足划分条件
        return preOrder(root.left, sum) | preOrder(root.right, sum);
    }

    /**
     * 后序遍历,求子数和
     *
     * @param root
     * @return
     */
    public int postOrder(TreeNode root) {
        if (root == null) return 0;
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        root.val += (left + right);
        return root.val;
    }

    /**
     * 前序遍历,判断条件
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean preOrder(TreeNode root, int sum) {
        if (root == null) return false;
        if (sum - root.val == root.val) return true;
        return preOrder(root.left, sum) | preOrder(root.right, sum);
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
