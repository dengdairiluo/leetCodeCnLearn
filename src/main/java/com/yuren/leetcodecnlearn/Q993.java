package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-11 23:46
 */
public class Q993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] xi = dfs(root, null, 0, x);
        int[] yi = dfs(root, null, 0, y);
        return xi[1] == yi[1] && xi[0] != yi[0];
    }

    int[] dfs(TreeNode root, TreeNode fa, int depth, int t) {
        // 使用 -1 代表为搜索不到 t
        if (root == null) {
            return new int[]{-1, -1};
        }
        if (root.val == t) {
            return new int[]{fa != null ? fa.val : 1, depth};
            // 使用 1 代表搜索值 t 为 root
        }
        int[] l = dfs(root.left, root, depth + 1, t);
        if (l[0] != -1) {
            return l;
        }
        return dfs(root.right, root, depth + 1, t);
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
