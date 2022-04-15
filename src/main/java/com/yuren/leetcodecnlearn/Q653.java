package com.yuren.leetcodecnlearn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-15 23:49
 */
public class Q653 {
    public boolean findTarget(TreeNode root, int k) {
        TreeNode left = root, right = root;
        Deque<TreeNode> leftStack = new ArrayDeque<>();
        Deque<TreeNode> rightStack = new ArrayDeque<>();
        leftStack.push(left);
        while (left.left != null) {
            leftStack.push(left.left);
            left = left.left;
        }
        rightStack.push(right);
        while (right.right != null) {
            rightStack.push(right.right);
            right = right.right;
        }
        while (left != right) {
            if (left.val + right.val == k) {
                return true;
            }
            if (left.val + right.val < k) {
                left = getLeft(leftStack);
            } else {
                right = getRight(rightStack);
            }
        }
        return false;
    }

    public TreeNode getLeft(Deque<TreeNode> stack) {
        TreeNode root = stack.pop();
        TreeNode node = root.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return root;
    }

    public TreeNode getRight(Deque<TreeNode> stack) {
        TreeNode root = stack.pop();
        TreeNode node = root.left;
        while (node != null) {
            stack.push(node);
            node = node.right;
        }
        return root;
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
