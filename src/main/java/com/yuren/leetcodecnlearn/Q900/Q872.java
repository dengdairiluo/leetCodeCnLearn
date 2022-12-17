package com.yuren.leetcodecnlearn.Q900;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-20 23:15
 */
public class Q872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> seq1 = new ArrayList<Integer>();
        if (root1 != null) {
            dfs(root1, seq1);
        }

        List<Integer> seq2 = new ArrayList<Integer>();
        if (root2 != null) {
            dfs(root2, seq2);
        }

        return seq1.equals(seq2);
    }

    public void dfs(TreeNode node, List<Integer> seq) {
        if (node.left == null && node.right == null) {
            seq.add(node.val);
        } else {
            if (node.left != null) {
                dfs(node.left, seq);
            }
            if (node.right != null) {
                dfs(node.right, seq);
            }
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
