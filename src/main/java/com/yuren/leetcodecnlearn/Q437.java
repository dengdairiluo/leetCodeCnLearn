package com.yuren.leetcodecnlearn;

import java.util.HashMap;
import java.util.Map;

public class Q437 {
    Map<Integer, Integer> map = new HashMap<>();
    int ans, t;

    public int pathSum(TreeNode root, int t) {
        if (root == null) return 0;
        this.t = t;
        map.put(0, 1);
        dfs(root, root.val);
        return ans;
    }

    void dfs(TreeNode root, int val) {
        if (map.containsKey(val - t)) ans += map.get(val - t);
        map.put(val, map.getOrDefault(val, 0) + 1);
        if (root.left != null) dfs(root.left, val + root.left.val);
        if (root.right != null) dfs(root.right, val + root.right.val);
        map.put(val, map.getOrDefault(val, 0) - 1);
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
