package com.yuren.leetcodecnlearn.Q200;

import java.util.ArrayList;
import java.util.List;

public class Q173 {

    TreeNode root;
    List<Integer> list = new ArrayList<>();
    int i = 0;

    public Q173(TreeNode root) {
        this.root = root;
        dfs(this.root);
    }

    public int next() {
        if (i == list.size() || list.size() == 0) {
            return 0;
        }
        int z = list.get(i);
        i++;
        return z;
    }

    public boolean hasNext() {
        return i < list.size();
    }

    public void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            list.add(root.val);
            dfs(root.right);
        }
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
