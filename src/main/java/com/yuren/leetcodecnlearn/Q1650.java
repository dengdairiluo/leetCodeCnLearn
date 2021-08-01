package com.yuren.leetcodecnlearn;

public class Q1650 {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p, b = q;
        while (a != b) {
            a = (a.parent == null) ? q : a.parent;
            b = (b.parent == null) ? p : b.parent;
        }
        return a;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }


}
