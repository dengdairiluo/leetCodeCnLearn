package com.yuren.leetcodecnlearn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-01-17 23:29
 */
public class Q456 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        // 递减栈，栈里元素都是比k大元素 即j
        // 思路就是 确定一个k(次大值) 之后，就去找比k小的值，若有 返回true
        Deque<Integer> stack = new ArrayDeque<>();
        int k = Integer.MIN_VALUE;
        // 逆序 这里保证 k的位置一定在 栈元素的 后边
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < k) {
                return true;
            }

            // 找到次大值即可
            while (!stack.isEmpty() && stack.peekLast() < nums[i]) {
                k = stack.removeLast();
            }
            stack.addLast(nums[i]);
        }
        return false;
    }
}
