package com.yuren.leetcodecnlearn.Q700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-09 23:36
 */
public class Q641 {
    DoublyLinkedList dll;

    public Q641(int k) {
        dll = new DoublyLinkedList(k);
    }

    public boolean insertFront(int value) {
        if (dll.size < dll.capacity) {
            Node n = new Node(value);
            dll.insertAtHead(n);
            return true;
        }
        return false;
    }

    public boolean insertLast(int value) {
        if (dll.size < dll.capacity) {
            Node n = new Node(value);
            dll.insertAtTail(n);
            return true;
        }
        return false;
    }

    public boolean deleteFront() {
        if (!dll.isEmpty()) {
            dll.removeAtHead();
            return true;
        }
        return false;
    }

    public boolean deleteLast() {
        if (!dll.isEmpty()) {
            dll.removeAtTail();
            return true;
        }
        return false;
    }

    public int getFront() {
        if (dll.isEmpty()) {
            return -1;
        }
        return dll.head.next.val;
    }

    public int getRear() {
        if (dll.isEmpty()) {
            return -1;
        }
        return dll.tail.prev.val;
    }

    public boolean isEmpty() {
        return dll.isEmpty();
    }

    public boolean isFull() {
        return dll.isFull();
    }

    class Node {
        int val;
        Node next, prev;

        public Node(int val) {
            this.val = val;
        }
    }

    class DoublyLinkedList {
        Node head = new Node(-1);
        Node tail = new Node(-1);
        int size;
        int capacity;

        public DoublyLinkedList(int capacity) {
            this.head.next = tail;
            this.tail.prev = head;
            this.size = 0;
            this.capacity = capacity;
        }

        public void insertAtTail(Node n) {
            Node prev = tail.prev;
            tail.prev = n;
            n.next = tail;
            prev.next = n;
            n.prev = prev;
            this.size++;
        }

        public void insertAtHead(Node n) {
            Node next = head.next;
            n.next = next;
            next.prev = n;
            n.prev = head;
            head.next = n;
            this.size++;
        }

        public void remove(Node n) {
            n.next.prev = n.prev;
            n.prev.next = n.next;
            this.size--;
        }

        public void removeAtTail() {
            remove(tail.prev);
        }

        public void removeAtHead() {
            remove(head.next);
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public boolean isFull() {
            return this.size == this.capacity;
        }

    }
}
