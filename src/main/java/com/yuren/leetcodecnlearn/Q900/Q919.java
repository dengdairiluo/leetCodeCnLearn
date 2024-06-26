package com.yuren.leetcodecnlearn.Q900;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-09 23:50
 */
public class Q919 {
    List<TreeNode> list = new ArrayList<>();
    int idx = 0;

    public Q919(TreeNode root) {
        list.add(root);
        int cur = 0;
        while (cur < list.size()) {
            TreeNode node = list.get(cur);
            if (node.left != null) list.add(node.left);
            if (node.right != null) list.add(node.right);
            cur++;
        }
    }

    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        while (list.get(idx).left != null && list.get(idx).right != null) {
            idx++;
        }
        TreeNode fa = list.get(idx);
        if (fa.left == null) {
            fa.left = node;
        } else if (fa.right == null) fa.right = node;
        list.add(node);
        return fa.val;
    }

    public TreeNode getRoot() {
        return list.get(0);
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
