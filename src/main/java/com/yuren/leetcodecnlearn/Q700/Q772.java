package com.yuren.leetcodecnlearn.Q700;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-05-15 23:25
 */
public class Q772 {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < source.length; i++) {

            int startBlock = source[i].indexOf("/*");
            int startLine = source[i].indexOf("//");

            if (startBlock >= 0 && (startLine < 0 || startBlock < startLine)) {

                String s = source[i].substring(0, startBlock);
                source[i] = source[i].substring(startBlock + 2);
                while (!source[i].contains("*/")) {
                    i++;
                }
                int blockEnd = source[i].indexOf("*/");
                source[i] = s + source[i].substring(blockEnd + 2);
                i--;
            } else if (startLine >= 0 && (startBlock < 0 || startLine < startBlock)) {
                source[i] = source[i].substring(0, startLine);
                i--;
            } else {
                if (!source[i].isEmpty()) {
                    res.add(source[i]);
                }
            }
        }
        return res;
    }

    public int calculate(String s) {
        int[] result = js(s,0);
        return result[0];
    }

    public int[] js(String s,int begin) {
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[2];
        char presign = '+';
        int n = s.length();
        int num = 0;
        for (int i = begin; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (c == '(') {
                int[] numNext = js(s,i + 1);
                num = numNext[0];
                i = numNext[1];
            }
            //对于末尾结束时 或 不是数字字符且字符不为'('时，对num进行处理
            if (i == n - 1 || !Character.isDigit(c) && c != '(') {
                switch (presign) {
                    case '+':deque.push(num);break;
                    case '-':deque.push(-num);break;
                    case '*':deque.push(deque.pop() * num);break;
                    default:deque.push(deque.pop() / num);break;
                }
                //如果结束是右括号，那么就记录位置结束循环。
                if (c == ')') {
                    result[1] = i;
                    break;
                }
                presign = c;
                num = 0;
            }

        }
        while (!deque.isEmpty()) {
            result[0] += deque.pop();
        }
        return result;
    }
}
