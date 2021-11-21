package com.yuren.leetcodecnlearn;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-11-21 23:50
 */
public class Q314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        // 层次遍历，初始化根节点为第0列（参照列）
        Queue<TreeNode> queue = new LinkedList<>(); // 记录结点
        Queue<Integer> colnum = new LinkedList<>();// 记录相对列
        queue.add(root);
        colnum.add(0);

        // 记录偏移值
        int offset = 0;
        Set<Integer> set = new HashSet<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int col = colnum.poll();
            // 第一次访问该列
            if (!set.contains(col)) {
                // 正数列插入后面，偏移值不变
                if (col >= 0) {
                    res.add(new LinkedList<>());
                }
                // 负数列插入前面，偏移值加一
                else {
                    res.add(0, new LinkedList<>());
                    offset++;
                }
                // 已访问集合加入列
                set.add(col);
            }
            // 根据偏移和相对列值获取数组，并拼接到后面
            res.get(offset + col).add(cur.val);
            // 加入下一层结点
            if (cur.left != null) {
                queue.add(cur.left);
                colnum.add(col - 1);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                colnum.add(col + 1);
            }
        }
        return res;
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
