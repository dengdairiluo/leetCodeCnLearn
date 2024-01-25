package com.yuren.leetcodecnlearn.Q2100;

import com.yuren.leetcodecnlearn.entity.TreeNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-25 23:38
 */
public class Q2196 {
    public TreeNode createBinaryTree(int[][] descriptions) {
        TreeNode[] tree = new TreeNode[100001];
        for (int[] d : descriptions) {
            int child = d[1];
            tree[child] = new TreeNode(child);
        }
        TreeNode root = null;
        for (int[] d : descriptions) {
            int parent = d[0], child = d[1], isLeft = d[2];
            if (tree[parent] == null) {
                tree[parent] = new TreeNode(parent);
                root = tree[parent];
            }
            if (isLeft == 1) {
                tree[parent].left = tree[child];
            } else {
                tree[parent].right = tree[child];
            }
        }
        return root;
    }
}
