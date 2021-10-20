package com.yuren.leetcodecnlearn;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-10-20 23:03
 */
public class Q277 {
    static Stack<Integer> num = new Stack<>();
    static Stack<Character> op = new Stack<>();
    static HashMap<Character, Integer> map = new HashMap<>();

    static void eval() {
        int b = num.pop();
        int a = num.pop();
        char c = op.pop();
        int r = 0;
        if (c == '+') r = a + b;
        else if (c == '-') r = a - b;
        else if (c == '*') r = a * b;
        else r = a / b;
        num.add(r);
    }

    public int calculate(String s) {
        s = '0' + s; // 对开头是负数的处理
        map.put('+', 1);   //定义运算符的优先级
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;  //跳过空格
            if (c >= '0' && c <= '9')  //c是数字,读取一个连续的数字
            {
                int x = 0, j = i;
                while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    x = x * 10 + s.charAt(j) - '0';
                    j++;
                }
                i = j - 1;
                num.add(x);
            } else  //c是操作符
            {     //op栈非空并且栈顶操作符优先级大于等于当前操作符c的优先级，进行eval()计算
                while (!op.isEmpty() && map.get(op.peek()) >= map.get(c)) eval();
                op.add(c);
            }
        }
        while (!op.isEmpty()) eval();
        return num.pop();
    }
}
