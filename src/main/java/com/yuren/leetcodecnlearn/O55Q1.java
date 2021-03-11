package com.yuren.leetcodecnlearn;

import java.util.LinkedList;
import java.util.List;

public class O55Q1 {

    private static int maxDepth(TreeNode root) {
        return countDepth(root, 0);
    }

    private static int countDepth(TreeNode node, int level) {
        if (node == null) {
            return level;
        }

        int leftLevel = countDepth(node.left, level + 1);
        int rightLevel = countDepth(node.right, level + 1);
        return Math.max(leftLevel, rightLevel);
    }

    private static int maxDepth1(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }

    private static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root);}}, tmp;
        int res = 0;
        while (!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for (TreeNode node : queue) {
                if (node.left != null) {
                    tmp.add(node.left);
                }
                if (node.right != null) {
                    tmp.add(node.right);
                }
            }
            queue = tmp;
            res++;
        }
        return res;

    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }



}
