package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-06 23:13
 */
public class Q1666 {
    Node ans;
    Node root;

    public Node flipBinaryTree(Node root, Node leaf) {
        this.root = root;
        if (root == null || leaf == null) {
            return root;
        }
        ans = null;
        help(leaf.parent, leaf, null);
        return ans;

    }

    private void help(Node p, Node leaf, Node np) {
        if (p == null) {
            return;
        }
        if (ans == null) {
            ans = leaf;
        }
        Node gp = p.parent;
        if (p.left == leaf) {
            p.left = null;
            p.parent = leaf;
            leaf.left = p;
            leaf.parent = np;
        } else {
            if (p == root) {
                p.right = null;
            } else {
                p.right = p.left;
                p.left = null;
            }
            p.parent = leaf;
            leaf.left = p;
            leaf.parent = np;
        }
        help(gp, p, leaf);

    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    ;
}
