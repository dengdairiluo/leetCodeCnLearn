package com.yuren.leetcodecnlearn.Q2100;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-09 23:58
 */
public class Q2102 {
    private final PriorityQueue<Node> maxHalf = new PriorityQueue<>(Comparator.reverseOrder());
    private final PriorityQueue<Node> minHalf = new PriorityQueue<>();
    private int c = 1;

    public Q2102() {

    }

    public void add(String name, int score) {
        Node ns = new Node(name, score);
        if (maxHalf.size() < c) {
            maxHalf.add(ns);
            return;
        }
        Node t = maxHalf.peek();
        if (t.compareTo(ns) <= 0) {
            minHalf.add(ns);
        } else {
            maxHalf.poll();
            minHalf.add(t);
            maxHalf.add(ns);
        }
    }

    public String get() {
        Node t = maxHalf.peek();
        c++;
        if (!minHalf.isEmpty()) {
            maxHalf.add(minHalf.poll());
        }
        return t.name;
    }

    private static class Node implements Comparable<Node> {

        String name;
        int score;

        public Node(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Node o) {
            if (score != o.score) {
                return o.score - score;
            }
            return name.compareTo(o.name);
        }
    }
}
