package com.yuren.leetcodecnlearn;

import java.util.BitSet;
import java.util.LinkedList;

public class Q1261 {
    LinkedList<TreeNode> ll = new LinkedList<>();
    private final BitSet bs = new BitSet();
    private int level = 1;//下一次遍历的层数
    private int total = 0;//假设是全二叉树应该包含的总数

    public Q1261(TreeNode root) {
        //BFS
        root.val = 0;
        ll.addLast(root);
    }

    public boolean find(int target) {
        while (target > total - 1) {//total-1是因为root是从0开始的，所以总数得少一个，才能遍历到下一层结果
            int length = ll.size();
            for (int i = 0; i < length; i++) {
                TreeNode node = ll.removeFirst();
                bs.set(node.val);
                if (node.left != null) {
                    node.left.val = 2 * node.val + 1;
                    ll.addLast(node.left);
                }
                if (node.right != null) {
                    node.right.val = 2 * node.val + 2;
                    ll.addLast(node.right);
                }
            }
            total += Math.pow(2, level - 1);
            level++;
        }
        return bs.get(target);
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
