package com.yuren.leetcodecnlearn.Q300;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-11-14 22:04
 */
public class Q297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(queue);
    }

    private TreeNode dfs(Queue<String> queue) {
        String val = queue.poll();
        if ("null".equals(val)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = dfs(queue);
        root.right = dfs(queue);
        return root;
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
