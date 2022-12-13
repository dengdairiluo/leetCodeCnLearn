package com.yuren.leetcodecnlearn.Q700;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-18 23:45
 */
public class Q662 {
    public int widthOfBinaryTree(TreeNode root) {
        // 如果结点为空，则宽度为0
        if (root == null) {
            return 0;
        }
        // 记录最大宽度
        int width = 0;
        // 队列1，放入TreeNode结点
        Deque<TreeNode> queue1 = new LinkedList<>();
        // 队列2，放入结点的位置索引
        Deque<Integer> queue2 = new LinkedList<>();
        // 放入root结点
        queue1.offerLast(root);
        // 放入root结点的位置索引
        queue2.offerLast(1);
        while (!queue1.isEmpty()) {
            // 当前层的结点数量
            int size = queue1.size();
            // 记录当前层的最大宽度
            int tmpWidth = 0;
            // 用于判断是否为当前层的第一个结点
            boolean flag = false;
            int left = -1, right = -1;
            // 遍历当前层的所有结点
            while (size-- > 0) {
                TreeNode node = queue1.pollFirst();
                int pos = queue2.pollFirst();
                // 遇到第一个结点
                if (!flag) {
                    flag = true;
                    left = pos;
                }
                right = pos;
                // 不停更新当前层的最大宽度
                tmpWidth = Math.max(tmpWidth, right - left + 1);
                if (node.left != null) {
                    queue1.offerLast(node.left);
                    queue2.offerLast(pos * 2);
                }
                if (node.right != null) {
                    queue1.offerLast(node.right);
                    queue2.offerLast(pos * 2 + 1);
                }
            }
            width = Math.max(width, tmpWidth);
        }
        return width;
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
