package com.yuren.leetcodecnlearn.Q1000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-25 23:39
 */
public class Q958 {
    int n = 0, p = 0;

    public boolean isCompleteTree(TreeNode root) {
        if (!dfs(root, 1)) {
            return false;
        }
        return n == p;
    }

    /**
     * k是当前节点编号
     *
     * @param root
     * @param k
     * @return
     */
    public boolean dfs(TreeNode root, int k) {
        //递归到了叶子节点
        if (root == null) {
            return true;
        }
        if (k > 100) {
            return false;
        }
        n++;
        //记录节点数和最大节点编号值
        p = Math.max(p, k);
        //递归左右子树
        return dfs(root.left, 2 * k) && dfs(root.right, 2 * k + 1);
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
