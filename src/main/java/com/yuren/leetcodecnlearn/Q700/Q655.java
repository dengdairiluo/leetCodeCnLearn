package com.yuren.leetcodecnlearn.Q700;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-17 23:22
 */
public class Q655 {
    public List<List<String>> printTree(TreeNode root) {
        //1.求出root的高度
        int maxDepth = getDepth(root);
        //2.求出输出List的宽度
        int width = 0, count = maxDepth;
        while (count-- > 0) {
            width = width * 2 + 1;
        }
        //对结果集初始化
        List<List<String>> res = new ArrayList<>(maxDepth);
        for (int i = 0; i < maxDepth; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                list.add("");
            }
            res.add(list);
        }
        //3.前序遍历，首先在结果集中填充左子树，然后填充右子树
        helper(root, 1, 0, width, res);
        return res;
    }

    private void helper(TreeNode root, int depth, int start, int end, List<List<String>> res) {
        if (root == null || start > end) return;
        //获取当前节点需要插入List的位置
        int insert = start + (end - start) / 2;
        //根据当前层数获得对应的List
        //插入根节点
        for (int i = start; i <= end; i++) {
            if (i == insert) {
                res.get(depth - 1).set(i, root.val + "");
                break;
            }
        }
        //递归打印左子树
        helper(root.left, depth + 1, start, insert - 1, res);
        helper(root.right, depth + 1, insert + 1, end, res);
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
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
