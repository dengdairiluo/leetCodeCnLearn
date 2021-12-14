package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-12-14 23:42
 */
public class Q373 {
    Comparator<Node> cmp1 = new Comparator<Node>() {
        @Override
        public int compare(Node a, Node b) {
            return b.sum - a.sum;
        }
    };

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        PriorityQueue<Node> maxHeap = new PriorityQueue<>(cmp1);

        for (int i = 0; i < Math.min(n1, k); i++) {
            for (int j = 0; j < Math.min(n2, k); j++) {
                if (maxHeap.size() < k) {
                    maxHeap.offer(new Node(nums1[i] + nums2[j], nums1[i], nums2[j]));
                } else {
                    if (maxHeap.peek().sum > nums1[i] + nums2[j]) {
                        maxHeap.poll();
                        maxHeap.offer(new Node(nums1[i] + nums2[j], nums1[i], nums2[j]));
                    }
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            Node t = maxHeap.poll();
            List<Integer> cur = new ArrayList<>();
            cur.add(t.x);
            cur.add(t.y);
            res.add(cur);
        }
        return res;

    }

    private static class Node {
        public int sum;
        public int x;
        public int y;

        Node(int sum, int x, int y) {
            this.sum = sum;
            this.x = x;
            this.y = y;
        }
    }
}
