package com.yuren.leetcodecnlearn.Q1400;

import com.yuren.leetcodecnlearn.entity.TreeNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-14 00:30
 */
public class Q1372 {

    int res = 0;

    public int longestZigZag(TreeNode root) {
        visit(root, 0, 0);
        return res;
    }

    private void visit(TreeNode root, int l, int r) {
        if (root == null) {
            return;
        }
        res = Math.max(res, Math.max(l, r));
        if (root.left != null) {
            visit(root.left, r + 1, 0);
        }
        if (root.right != null) {
            visit(root.right, 0, l + 1);
        }
    }
}
