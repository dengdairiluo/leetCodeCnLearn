package com.yuren.leetcodecnlearn.Q1200;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-26 23:45
 */
public class Q1106 {
    public boolean parseBoolExpr(String expression) {
        // 使用双端队列来模拟栈
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : expression.toCharArray()) {
            // 跳过就好了，不需要往栈里面放
            if (c == ',') {
                continue;
            }
            // 放进栈里面去，标记嵌套的起始位置
            if (c != ')') {
                stack.addLast(c);
            } else {
                // 创建一个新栈
                Deque<Character> buffer = new ArrayDeque<>();
                // 把括号中间的字符都放到新栈中去
                while (stack.peekLast() != '(') {
                    buffer.push(stack.pollLast());
                }
                stack.pollLast();   // 去掉 ( 字符
                // 再处理新栈中的表达式，获取处理结果 ret
                char ret = helper(buffer, stack.pollLast());
                // 再把处理结果放到栈中
                stack.offerLast(ret);
            }
        }
        return stack.peek() == 't';
    }

    private char helper(Deque<Character> buffer, char operator) {
        // 如果 `operator == !` 那么说明新栈里面只会有一个字符，反转就好了
        if (operator == '!') return buffer.pollLast() == 't' ? 'f' : 't';
        if (operator == '&') {
            // 如果是 & 那么就需要 buffer 里面全是 t 时，才返回 t，只要有一个 f 就返回 f
            while (!buffer.isEmpty()) {
                if (buffer.pollLast() == 'f') {
                    return 'f';
                }
            }
            return 't';
        } else {
            // 如果是 | 那么就需要 buffer 里面全是 f 时，才返回 f，只要有一个 t，就返回 t
            while (!buffer.isEmpty()) {
                if (buffer.pollLast() == 't') {
                    return 't';
                }
            }
            return 'f';
        }
    }
}
