package com.yuren.leetcodecnlearn.Q700;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-05-20 23:53
 */
public class Q735 {
    public int[] asteroidCollision(int[] asteroids) {
        int l = asteroids.length;
        Deque<Integer> stack = new LinkedList<>();//定义一个辅助栈
        int i = 0;
        while (i < l) {
            //flag用于未进入循环情况下或者栈顶元素已经不可能大于当前元素的情况下，将当前元素入栈；
            boolean flag = false;
            //异号并且栈不空时进入循环
            while (!stack.isEmpty() && ((asteroids[i] * stack.peek()) < 0)) {
                //当前元素绝对值小于栈顶元素绝对值，当前元素不入栈，跳出循环
                if (asteroids[i] < 0 && Math.abs(stack.peek()) > Math.abs(asteroids[i])) {
                    flag = true;
                    break;
                //当前元素绝对值大于栈顶元素绝对值，栈顶元素出栈，当前元素继续与新栈顶元素比较
                } else if (asteroids[i] < 0 && Math.abs(stack.peek()) < Math.abs(asteroids[i])) {
                    stack.pop();
                //当前元素绝对值等于栈顶元素绝对值，栈顶元素出栈，当前元素不入栈
                } else if (asteroids[i] < 0 && Math.abs(stack.peek()) == Math.abs(asteroids[i])) {
                    stack.pop();
                    flag = true;
                    break;
                } else break;
            //其他情况 当前元素入栈
            }
            if (!flag) stack.push(asteroids[i]);
            i++;
        }
        //将栈中元素添加到数组中并返回
        int[] ret = new int[stack.size()];
        for (int j = stack.size() - 1; j >= 0; j--) {
            ret[j] = stack.pop();
        }
        return ret;
    }
}
