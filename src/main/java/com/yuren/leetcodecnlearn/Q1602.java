package com.yuren.leetcodecnlearn;

import java.util.LinkedList;
import java.util.Queue;

public class Q1602 {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode cur = q.poll();
                if (cur == u)
                    return i < size - 1 ? q.poll() : null;
                if (null != cur.left) q.offer(cur.left);
                if (null != cur.right) q.offer(cur.right);
            }
        }

        return null;
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
