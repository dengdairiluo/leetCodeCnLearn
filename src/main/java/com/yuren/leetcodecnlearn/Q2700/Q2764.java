package com.yuren.leetcodecnlearn.Q2700;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-11-05 23:41
 */
public class Q2764 {
    public boolean isPreorder(List<List<Integer>> nodes) {
        if (nodes.get(0).get(1) != -1) {
            return false;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(nodes.get(0).get(0));
        int size = nodes.size();
        for (int i = 1; i < size; i++) {
            List<Integer> node = nodes.get(i);
            int child = node.get(0), parent = node.get(1);
            while (!stack.isEmpty() && stack.peek() != parent) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                return false;
            }
            stack.push(child);
        }
        return true;
    }
}
