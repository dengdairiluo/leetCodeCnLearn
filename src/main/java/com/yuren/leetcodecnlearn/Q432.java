package com.yuren.leetcodecnlearn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q432 {
    /**
     * this is to map string to its frequency;
     */
    private final Map<String, Integer> cache;
    /**
     * this is to map the frequency to a double linked list node which stores the strings with the same frequency;
     */
    private final Map<Integer, DlNode> freq;
    /**
     * the head and tail of the DLNode list; node with higher frequency is in front of the list
     */
    private final DlNode head;
    private final DlNode tail;

    private static class DlNode {
        int val;
        Set<String> keys;
        DlNode pre, next;

        public DlNode(int val) {
            this.val = val;
            this.keys = new HashSet<>();
        }
    }

    public Q432() {
        cache = new HashMap<>();
        freq = new HashMap<>();
        head = new DlNode(0);
        tail = new DlNode(0);
        head.next = tail;
        tail.pre = head;
    }

    public void inc(String key) {
        if (cache.containsKey(key)) {
            int val = cache.get(key);
            cache.put(key, val + 1);
            DlNode node = freq.get(val);
            // remove the key from the original node;
            node.keys.remove(key);
            DlNode preNode = node.pre;
            if (preNode == head || preNode.val > val + 1) {
                DlNode newNode = new DlNode(val + 1);
                newNode.keys.add(key);
                newNode.next = node;
                node.pre = newNode;
                newNode.pre = preNode;
                preNode.next = newNode;
                freq.put(val + 1, newNode);
                preNode = newNode;
            } else {
                preNode.keys.add(key);
            }
            if (node.keys.size() == 0) {
                preNode.next = node.next;
                node.next.pre = preNode;
                freq.remove(val);
            }
        } else {
            cache.put(key, 1);
            DlNode node = freq.get(1);
            if (node == null) {
                DlNode newNode = new DlNode(1);
                newNode.keys.add(key);
                tail.pre.next = newNode;
                newNode.pre = tail.pre;
                newNode.next = tail;
                tail.pre = newNode;
                freq.put(1, newNode);
            } else {
                node.keys.add(key);
            }
        }
    }

    public void dec(String key) {
        if (cache.containsKey(key)) {
            int val = cache.get(key);
            DlNode node = freq.get(val);
            node.keys.remove(key);
            if (val == 1) {
                cache.remove(key);
            } else {
                cache.put(key, val - 1);
                DlNode nextNode = node.next;
                if (nextNode == tail || nextNode.val < val - 1) {
                    DlNode newNode = new DlNode(val - 1);
                    newNode.keys.add(key);
                    node.next = newNode;
                    newNode.pre = node;
                    newNode.next = nextNode;
                    nextNode.pre = newNode;
                    freq.put(val - 1, newNode);
                } else {
                    nextNode.keys.add(key);
                }
            }
            if (node.keys.size() == 0) {
                node.pre.next = node.next;
                node.next.pre = node.pre;
                freq.remove(val);
            }
        }
    }

    public String getMaxKey() {
        if (head.next == tail) {
            return "";
        } else {
            return head.next.keys.iterator().next();
        }
    }

    public String getMinKey() {
        if (head.next == tail) {
            return "";
        } else {
            return tail.pre.keys.iterator().next();
        }
    }
}
