package com.yuren.leetcodecnlearn.Q600;

public class Q510 {
    private Node minNode = new Node(Integer.MAX_VALUE);

    public Node inorderSuccessor(Node node) {
        Node p = node;
        while (p.parent != null) {
            if (p.parent.val > node.val) {
                minNode = p.parent;
                break;
            }
            p = p.parent;
        }
        if (node.right != null) {
            Node min = helper(node.right);
            minNode = minNode.val < min.val ? minNode : min;
        }
        if (minNode.val == Integer.MAX_VALUE) {
            return null;
        }
        return minNode;
    }

    private Node helper(Node node) {
        if (node == null) {
            return new Node(Integer.MAX_VALUE);
        }
        if (node.left != null) {
            return helper(node.left);
        }
        return node;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;

        public Node() {
        }

        public Node(int value) {
            this.val = value;
        }
    }
}
