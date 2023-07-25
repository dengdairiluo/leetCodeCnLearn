package com.yuren.leetcodecnlearn.Q1700;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-25 23:48
 */
public class Q1797 {
    int timeToLive;
    Node head;
    Node tail;
    Map<String, Node> map;

    public Q1797(int timeToLive) {
        this.timeToLive = timeToLive;
        this.head = new Node(-1);
        this.tail = new Node(-1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.map = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        Node node = new Node(currentTime + timeToLive, tokenId);
        map.put(tokenId, node);
        Node last = tail.prev;
        last.next = node;
        node.prev = last;
        tail.prev = node;
        node.next = tail;
    }

    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId) && map.get(tokenId).expire > currentTime) {
            Node node = map.get(tokenId);
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            node.expire = currentTime + timeToLive;
            Node last = tail.prev;
            last.next = node;
            node.prev = last;
            tail.prev = node;
            node.next = tail;
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        while (head.next.expire > 0 && head.next.expire <= currentTime) {
            Node node = head.next;
            map.remove(node.key);
            head.next = node.next;
            node.next.prev = head;
        }
        return map.size();
    }

    private static class Node {
        int expire;
        String key;
        Node prev;
        Node next;

        public Node(int expire) {
            this(expire, null, null, null);
        }

        public Node(int expire, String key) {
            this(expire, key, null, null);
        }

        public Node(int expire, String key, Node prev, Node next) {
            this.expire = expire;
            this.key = key;
            this.prev = prev;
            this.next = next;
        }
    }
}
