package com.yuren.leetcodecnlearn.Q1400;

import java.util.HashMap;
import java.util.Map;

public class Q1484 {

    Map<Node, NodeCopy> cache = new HashMap<>();

    public NodeCopy copyRandomBinaryTree(Node root) {
        if (null == root) {
            return null;
        } else if (cache.containsKey(root)) {
            return cache.get(root);
        } else {
            NodeCopy copy = new NodeCopy(root.val);
            cache.put(root, copy);
            copy.left = copyRandomBinaryTree(root.left);
            copy.right = copyRandomBinaryTree(root.right);
            copy.random = copyRandomBinaryTree(root.random);
            return copy;
        }
    }


    private static class Node {
        int val;
        Node left;
        Node right;
        Node random;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right, Node random) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.random = random;
        }
    }

    private static class NodeCopy {
        int val;
        NodeCopy left;
        NodeCopy right;
        NodeCopy random;

        NodeCopy() {
        }

        NodeCopy(int val) {
            this.val = val;
        }

        NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.random = random;
        }
    }

}
