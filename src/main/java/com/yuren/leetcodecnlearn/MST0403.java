package com.yuren.leetcodecnlearn;

import java.util.LinkedList;
import java.util.Queue;

public class MST0403 {
    private static ListNode[] listOfDepth(TreeNode tree) {
        int depth = getDepth(tree);
        ListNode[] ans = new ListNode[depth];
        int index = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode newHead = new ListNode(0);
            ListNode head = newHead;
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                head.next = new ListNode(tmp.val);
                head = head.next;
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            ans[index++] = newHead.next;
        }
        return ans;
    }

    private static int getDepth(TreeNode tree) {
        if (tree == null) return 0;
        return Math.max(getDepth(tree.left), getDepth(tree.right)) + 1;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
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
