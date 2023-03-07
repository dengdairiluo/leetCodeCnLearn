package com.yuren.leetcodecnlearn.Q600;

public class Q654 {

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }


    private static TreeNode construct(int[] nums, int l, int r) {
        if (l == r) {
            return null;
        }
        int maxI = max(nums, l, r);
        TreeNode root = new TreeNode(nums[maxI]);
        root.left = construct(nums, l, maxI);
        root.right = construct(nums, maxI + 1, r);
        return root;
    }


    private static int max(int[] nums, int l, int r) {
        int maxI = l;

        for (int i = l; i < r; i++) {
            if (nums[maxI] < nums[i]) {
                maxI = i;
            }
        }

        return maxI;
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
