package com.yuren.leetcodecnlearn.Q1500;

import java.util.ArrayList;
import java.util.List;

public class Q1469 {

    private static final List<Integer> ans = new ArrayList<>();

    private static List<Integer> getLonelyNodes1(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return ans;
        }

        if (root.left == null && root.right != null) {
            ans.add(root.right.val);
        }

        if (root.left != null && root.right == null) {
            ans.add(root.left.val);
        }

        List<Integer> l = getLonelyNodes1(root.left);
        List<Integer> r = getLonelyNodes1(root.right);
        ans.addAll(l);
        ans.addAll(r);
        return ans;
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
