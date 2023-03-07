package com.yuren.leetcodecnlearn.Q200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-11-06 22:58
 */
public class Q272 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Queue<Integer> q = new LinkedList<>();
        inorder(q, root, target, k);
        return new ArrayList<>(q);
    }

    private void inorder(Queue<Integer> q, TreeNode root, double target, int k) {
        if (root == null) {
            return;
        }
        inorder(q, root.left, target, k);
        if (q.size() == k) {
            if (Double.compare(Math.abs(q.peek() - target), Math.abs(root.val - target)) > 0) {
                q.poll();
                q.offer(root.val);
            } else {
                return;
            }
        } else {
            q.offer(root.val);
        }
        inorder(q, root.right, target, k);
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
