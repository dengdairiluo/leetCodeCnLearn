package com.yuren.leetcodecnlearn.Q1500;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-05 22:34
 */
public class Q1429 {
    Map<Integer, Node> map = new HashMap<>();

    Node list = new Node();

    public Q1429(int[] nums) {
        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        return list.next.value;
    }

    public void add(int value) {
        Node node = map.get(value);
        if (node == null) {
            node = new Node(value);
            list.add(node);
            map.put(value, node);
        } else {
            node.remove();
            node = null;
        }
    }

    private static class Node {
        public Integer value;
        public Node next;
        public Node pre;

        Node() {
            this.pre = this.next = this;
            this.value = -1;
        }

        Node(int value) {
            this.value = value;
        }

        public void add(Node newNode) {
            pre.next = newNode;
            newNode.pre = pre;

            newNode.next = this;
            pre = newNode;
        }

        public void remove() {
            pre.next = this.next;
            next.pre = pre;
            next = pre = this;
        }
    }
}
