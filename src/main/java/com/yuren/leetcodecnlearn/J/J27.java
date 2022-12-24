package com.yuren.leetcodecnlearn.J;

import com.yuren.leetcodecnlearn.entity.TreeNode;

import java.util.Stack;

public class J27 {

    private static TreeNode mirrorTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree1(root.right);
        root.right = mirrorTree1(tmp);
        return root;

    }

    private static TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>() {{
            add(root);
        }};
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }

    public static void main(String[] args) {

    }


}
