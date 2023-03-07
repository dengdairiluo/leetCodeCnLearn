package com.yuren.leetcodecnlearn.Q300;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-07-03 22:57
 */
public class Q366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        while (root != null) {
            List list = new ArrayList<>();
            root = recur(root, list);
            resList.add(list);
        }
        return resList;
    }

    private TreeNode recur(TreeNode root, List<Integer> list) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return null;
        }
        root.left = recur(root.left, list);
        root.right = recur(root.right, list);
        return root;
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
