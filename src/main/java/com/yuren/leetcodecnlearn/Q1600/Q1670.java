package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-08 23:56
 */
public class Q1670 {
    int size;
    Node head;
    Node tail;
    Node mid;
    public Q1670() {
        size = 0;
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.pre = head;
        mid = null;
    }

    public void pushFront(int val) {
        Node cur = new Node(val);
        cur.next = head.next;
        cur.pre = head;
        cur.next.pre = cur;
        cur.pre.next = cur;
        size++;
        if (size == 1) {
            mid = cur;
        } else {
            if (size % 2 == 0) {
                mid = mid.pre;
            }
        }
    }

    public void pushMiddle(int val) {
        if (size == 0) {
            Node cur = new Node(val);
            cur.next = head.next;
            cur.pre = head;
            cur.next.pre = cur;
            cur.pre.next = cur;
            size++;
            mid = cur;
        } else {
            if (size % 2 != 1) {
                Node cur = new Node(val);
                cur.next = mid.next;
                cur.pre = mid;
                cur.next.pre = cur;
                cur.pre.next = cur;
                size++;
                mid = mid.next;
            } else {
                Node cur = new Node(val);
                cur.next = mid;
                cur.pre = mid.pre;
                cur.next.pre = cur;
                cur.pre.next = cur;
                size++;
                mid = mid.pre;
            }
        }
    }

    public void pushBack(int val) {
        Node cur = new Node(val);
        cur.next = tail;
        cur.pre = tail.pre;
        cur.next.pre = cur;
        cur.pre.next = cur;
        size++;
        if (size == 1) {
            mid = cur;
        } else {
            if (size % 2 != 0) {
                mid = mid.next;
            }
        }
    }

    public int popFront() {
        if (size == 0) {
            return -1;
        }
        Node cur = head.next;
        head.next = head.next.next;
        head.next.pre = head;
        size--;
        if (size == 0) {
            mid = null;
        } else {
            if (size % 2 == 1) {
                mid = mid.next;
            }
        }
        cur.next = null;
        cur.pre = null;
        return cur.val;
    }

    public int popMiddle() {
        if (size == 0) {
            return -1;
        }
        Node cur = mid;
        mid.pre.next = mid.next;
        mid.next.pre = mid.pre;
        size--;
        if (size == 0) {
            mid = null;
        } else {
            if (size % 2 == 1) {
                mid = mid.next;
            } else {
                mid = mid.pre;
            }
        }
        cur.next = null;
        cur.pre = null;
        return cur.val;
    }

    public int popBack() {
        if (size == 0) {
            return -1;
        }
        Node cur = tail.pre;
        cur.pre.next = tail;
        tail.pre = cur.pre;
        size--;
        if (size == 0) {
            mid = null;
        } else {
            if (size % 2 == 0) {
                mid = mid.pre;
            }
        }
        cur.next = null;
        cur.pre = null;
        return cur.val;
    }

    private static class Node {
        int val;
        Node pre;
        Node next;

        public Node(int val) {
            this.val = val;
            this.pre = null;
            this.next = null;
        }
    }
}
