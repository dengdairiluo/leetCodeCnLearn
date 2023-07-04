package com.yuren.leetcodecnlearn.Q1700;

import com.yuren.leetcodecnlearn.entity.TreeNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-04 23:44
 */
public class Q1740 {
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode parent = findP(root, p, q);
        int l = dfs(parent, p);
        int r = dfs(parent, q);
        return l + r;
    }

    TreeNode findP(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (root.val == p || root.val == q) return root;
        TreeNode l = findP(root.left, p, q);
        TreeNode r = findP(root.right, p, q);
        if (r != null && l != null) return root;

        return l == null ? r : l;
    }

    int dfs(TreeNode root, int x) {
        if (root == null) return -1;
        if (root.val == x) {
            return 0;
        }
        int l = dfs(root.left, x);
        if (l != -1) {
            return l + 1;
        }

        int r = dfs(root.right, x);
        if (r != -1) {
            return r + 1;
        }
        return -1;
    }
}
