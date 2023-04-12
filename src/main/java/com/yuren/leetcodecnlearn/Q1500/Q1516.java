package com.yuren.leetcodecnlearn.Q1500;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-12 23:26
 */
public class Q1516 {
    public Node moveSubTree(Node root, Node p, Node q) {
        if (isParent(q, p)) {
            return root;
        }
        if (p == root) {
            Node qParent = findParent(root, q);
            qParent.children.remove(q);
            q.children.add(p);
            return q;
        }
        if (isAncestor(p, q)) {
            Node qParent = findParent(p, q);
            qParent.children.remove(q);
            Node pParent = findParent(root, p);
            int i = 0;
            for (Node x : pParent.children) {
                if (x == p) {
                    pParent.children.set(i, q);
                }
                i++;
            }
            q.children.add(p);
            return root;
        }
        Node pParent = findParent(root, p);
        pParent.children.remove(p);
        q.children.add(p);
        return root;
    }

    private boolean isAncestor(Node p, Node q) {
        for (Node child : p.children) {
            if (child == q || isAncestor(child, q)) {
                return true;
            }
        }
        return false;
    }

    private boolean isParent(Node p, Node q) {
        for (Node child : p.children) {
            if (child == q) {
                return true;
            }
        }
        return false;
    }

    private Node findParent(Node cur, Node p) {
        return findParent(null, cur, p);
    }

    private Node findParent(Node parent, Node cur, Node p) {
        if (cur == p) {
            return parent;
        }
        for (Node child : cur.children) {
            Node res = findParent(cur, child, p);
            if (res != null) {
                return res;
            }
        }
        return null;
    }

    private static class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            children = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

}
