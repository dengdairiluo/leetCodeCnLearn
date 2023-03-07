package com.yuren.leetcodecnlearn.Q400;

public class Q430 {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    Node dfs(Node head) {
        Node last = head;
        while (head != null) {
            if (head.child == null) {
                last = head;
                head = head.next;
            } else {
                Node tmp = head.next;
                Node childLast = dfs(head.child);
                head.next = head.child;
                head.child.prev = head;
                head.child = null;
                if (childLast != null) childLast.next = tmp;
                if (tmp != null) tmp.prev = childLast;
                last = head;
                head = childLast;
            }
        }
        return last;
    }

    private static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
