package com.yuren.leetcodecnlearn.Q2700;

import com.yuren.leetcodecnlearn.entity.TreeNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-11-10 02:52
 */
public class Q2773 {
    public int heightOfTree(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (isLeaf(root)) {
            return 0;
        }
        return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
    }

    public boolean isLeaf(TreeNode node) {
        if (node.left == null || node.right == null) {
            return false;
        }
        return node.left.right == node && node.right.left == node;
    }
}
