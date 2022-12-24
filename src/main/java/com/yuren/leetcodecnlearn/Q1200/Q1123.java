package com.yuren.leetcodecnlearn.Q1200;

import com.yuren.leetcodecnlearn.entity.TreeNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-02 23:22
 */
public class Q1123 {
    TreeNode res = null;
    int pre = 0;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 1);
        return res;

    }

    int dfs(TreeNode node, int depth) {
        if (node == null) return depth;
        int left = dfs(node.left, depth + 1);
        int right = dfs(node.right, depth + 1);
        if (left == right && left >= pre) {
            res = node;
            pre = left;
        }
        return Math.max(left, right);
    }
}
