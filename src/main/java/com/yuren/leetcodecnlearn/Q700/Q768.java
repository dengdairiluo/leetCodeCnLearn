package com.yuren.leetcodecnlearn.Q700;

import java.util.LinkedList;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-06-04 23:12
 */
public class Q768 {
    public int maxChunksToSorted(int[] arr) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int num : arr) {
            if (!stack.isEmpty() && num < stack.getLast()) {
                int head = stack.removeLast();
                while (!stack.isEmpty() && num < stack.getLast()) {
                    stack.removeLast();
                }
                stack.addLast(head);
            } else {
                stack.addLast(num);
            }
        }
        return stack.size();
    }
}
