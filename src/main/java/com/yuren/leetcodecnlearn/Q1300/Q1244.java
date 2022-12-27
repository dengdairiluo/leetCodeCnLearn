package com.yuren.leetcodecnlearn.Q1300;

import java.util.HashMap;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-27 23:37
 */
public class Q1244 {
    private static class ListNode {
        ListNode prev;
        ListNode next;
        int value = 0;

        public ListNode(int val) {
            value = val;
        }
    }

    HashMap<Integer, ListNode> map;
    ListNode head = new ListNode(1000001);
    ListNode tail = new ListNode(0);

    public Q1244() {
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public void addScore(int playerId, int score) {
        ListNode current = new ListNode(0);
        if (map.containsKey(playerId)) {
            current = map.get(playerId);
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        current.value += score;
        map.put(playerId, current);
        insert(current);
    }

    public int top(int K) {
        ListNode current = head.next;
        int result = 0;
        while (K > 0) {
            result += current.value;
            current = current.next;
            K -= 1;
        }

        return result;
    }

    public void reset(int playerId) {
        ListNode current = map.get(playerId);
        map.remove(playerId);
        current.prev.next = current.next;
        current.next.prev = current.prev;
    }

    public void insert(ListNode node) {
        ListNode current = head;
        while (node.value < current.value) {
            current = current.next;
        }

        node.prev = current.prev;
        node.next = current;
        current.prev = node;
        node.prev.next = node;
    }
}
