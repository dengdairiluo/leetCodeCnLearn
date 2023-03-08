package com.yuren.leetcodecnlearn.Q1600;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Q1660 {
    public TreeNode correctBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Map<Integer, TreeNode> map = new HashMap<>();
        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    q.offer(cur.left);
                    map.put(cur.left.val, cur);
                }
                if (cur.right != null) {
                    if (map.containsKey(cur.right.val)) {
                        TreeNode t = map.get(cur.val);
                        if (t.left != null && t.left.val == cur.val) {
                            t.left = null;
                        } else {
                            t.right = null;
                        }
                        return root;
                    }
                    q.offer(cur.right);
                    map.put(cur.right.val, cur);
                }
            }
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
