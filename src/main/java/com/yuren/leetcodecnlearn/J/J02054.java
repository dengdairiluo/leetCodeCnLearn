package com.yuren.leetcodecnlearn.J;

import com.yuren.leetcodecnlearn.entity.TreeNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-08-07 20:36
 */
public class J02054 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        return root;
    }

    /**
     * 改进版的中序遍历
     *
     * @param root
     */
    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.right);
        sum += root.val;
        root.val = sum;
        inorder(root.left);
    }

}
