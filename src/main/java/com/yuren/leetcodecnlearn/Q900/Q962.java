package com.yuren.leetcodecnlearn.Q900;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-27 23:34
 */
public class Q962 {
    public int maxWidthRamp(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || arr[stack.peek()] > arr[i]) {
                stack.push(i);
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                int cur = stack.pop();
                res = Math.max(res, i - cur);
            }
        }
        return res;
    }
}
