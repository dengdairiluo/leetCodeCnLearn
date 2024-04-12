package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-29 22:18
 */
public class Q1803 {
    private static void add(Node node, int x) {
        for (int i = 14; i >= 0; i--) {
            int ge = (x >> i) & 1;
            if (node.next[ge] == null) node.next[ge] = new Node(1);
            else node.next[ge].count++;
            node = node.next[ge];
        }
    }

    private static int query(Node node, int x, int high) {
        int res = 0;
        for (int i = 14; i >= 0; i--) {
            int h = (high >> i) & 1;
            int ge = (x >> i) & 1;
            if (h == 0) {
                node = node.next[ge];
                if (node == null) return res;
            } else {
                res += node.next[ge] == null ? 0 : node.next[ge].count;
                node = node.next[ge ^ 1];
                if (node == null) return res;
            }
        }
        res += node.count;
        return res;
    }

    public int countPairs(int[] nums, int low, int high) {
        Node root = new Node(0);
        int hs = 0, ls = 0;
        for (int num : nums) {
            ls += query(root, num, low - 1);
            hs += query(root, num, high);
            add(root, num);
        }
        return hs - ls;
    }

    private static class Node {
        int count;
        Node[] next = new Node[2];

        public Node(int count) {
            this.count = count;
        }
    }
}
