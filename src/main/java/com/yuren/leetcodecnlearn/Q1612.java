package com.yuren.leetcodecnlearn;

import java.util.HashMap;
import java.util.Map;

public class Q1612 {
    Map<Character, Integer> map = new HashMap<>();
    boolean stop = false;

    public boolean checkEquivalence(Node root1, Node root2) {
        inOrder(root1, true);
        inOrder(root2, false);
        if (stop) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }

        return true;
    }

    private void inOrder(Node node, boolean flag) {
        if (node == null || stop) {
            return;
        }
        inOrder(node.left, flag);
        char val = node.val;
        if (flag) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        } else {
            Integer value = map.get(val);
            if (value == null) {
                stop = true;
            } else {
                map.put(val, value - 1);
            }
        }
        inOrder(node.right, flag);
    }

      class Node {
      char val;
      Node left;
      Node right;
      Node() {this.val = ' ';}
      Node(char val) { this.val = val; }
      Node(char val, Node left, Node right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

}
