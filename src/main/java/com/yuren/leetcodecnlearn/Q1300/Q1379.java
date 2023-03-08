package com.yuren.leetcodecnlearn.Q1300;

public class Q1379 {


    public final TreeNode getTargetCopy1(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        return dfs(cloned, target);
    }

    private TreeNode dfs(final TreeNode cloned, final TreeNode target) {

        if (target.val == cloned.val) {
            return cloned;
        }

        if (null != cloned.left) {
            TreeNode leftResult = dfs(cloned.left, target);
            if (null != leftResult) {
                return leftResult;
            }
        }

        if (null != cloned.right) {
            TreeNode rightResult = dfs(cloned.right, target);
            return rightResult;
        }
        return null;
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }

        if (original == target) {
            return cloned;
        }

        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left != null) {
            return left;
        }

        return getTargetCopy(original.right, cloned.right, target);
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
