package com.yuren.leetcodecnlearn.Q200;

import java.util.ArrayList;
import java.util.List;

public class Q257 {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<String> leftTree = binaryTreePaths(root.left);
        List<String> rightTree = binaryTreePaths(root.right);
        List<String> res = new ArrayList<>();
        StringBuilder thisRes = new StringBuilder();
        thisRes.append(root.val).append("->");
        if (leftTree != null) {
            for (String s : leftTree) {
                res.add(thisRes.append(s).toString());
                thisRes.delete(0, thisRes.length());
                thisRes.append(root.val).append("->");
            }
        }
        if (rightTree != null) {
            for (String s : rightTree) {
                res.add(thisRes.append(s).toString());
                thisRes.delete(0, thisRes.length());
                thisRes.append(root.val).append("->");
            }
        }
        if (leftTree == null && rightTree == null) {
            res.add(String.valueOf(root.val));
        }
        return res;
    }

    private class TreeNode {
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
