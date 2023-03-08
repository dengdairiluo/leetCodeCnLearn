package com.yuren.leetcodecnlearn.Q1300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1305 {
    List<Integer> list = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inOrder(root1);
        inOrder(root2);
        //排序
        Collections.sort(list);
        return list;
    }

    //中序遍历
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
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
