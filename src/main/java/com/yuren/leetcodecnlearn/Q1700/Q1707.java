package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-21 23:03
 */
public class Q1707 {
    private static class TreeNode {
        int minNum;

        TreeNode(int minNum) {
            this.minNum = minNum;
        }

        TreeNode left, right;
    }

    private TreeNode root;

    private int treeHeight;

    private void initTreeHeight(int[] nums) {
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        int h = 1;
        for (; (maxNum >>> h) != 0; h++) {
            ;
        }
        treeHeight = h;
    }

    private void addNode(int num) {
        TreeNode node = root;
        node.minNum = Math.min(node.minNum, num);
        for (int bit = 1 << treeHeight - 1; bit != 0; bit >>>= 1) {
            if ((num & bit) == 0) {
                if (node.left == null) {
                    node.left = new TreeNode(num);
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(num);
                }
                node = node.right;
            }
            node.minNum = Math.min(node.minNum, num);
        }
    }

    private int queryMaxXor(int x, int m) {
        if (root.minNum > m) {
            return -1;
        }
        TreeNode node = root;
        for (int bit = 1 << treeHeight - 1; bit != 0; bit >>>= 1) {
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (right == null || right.minNum > m || left != null && (x & bit) != 0) {
                node = left;
            } else {
                node = right;
            }
        }
        return x ^ node.minNum;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {

        initTreeHeight(nums);

        root = new TreeNode(Integer.MAX_VALUE);
        for (int num : nums) {
            addNode(num);
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = queryMaxXor(queries[i][0], queries[i][1]);
        }
        return result;
    }
}
