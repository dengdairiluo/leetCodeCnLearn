package com.yuren.leetcodecnlearn.Q1400;

import java.util.LinkedList;
import java.util.List;

public class Q1302 {

    private static int maxLevel = -1;

    private static int total = 0;

    private static int deepestLeavesSum1(TreeNode root) {
        dfs(root, 0);
        return total;
    }

    private static void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        level++;

        if (level > maxLevel) {
            maxLevel = level;
            total = node.val;
        } else if (level == maxLevel) {
            total += node.val;
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }


    private static int deepestLeavesSum2(TreeNode root) {
        List<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }}, tmp;
        int total = 0;
        while (!queue.isEmpty()) {
            tmp = new LinkedList<>();
            total = 0;
            for (TreeNode node : queue) {
                if (node.left != null) {
                    tmp.add(node.left);
                }
                if (node.right != null) {
                    tmp.add(node.right);
                }
                total += node.val;
            }
            queue = tmp;
        }
        return total;
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
