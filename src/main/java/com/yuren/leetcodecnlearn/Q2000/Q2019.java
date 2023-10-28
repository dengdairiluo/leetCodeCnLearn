package com.yuren.leetcodecnlearn.Q2000;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-28 23:35
 */
public class Q2019 {
    Map<String, Set<Integer>> mem;

    // 计算表达式正确答案
    public int calc(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                int n = s.charAt(++i) - '0';
                stack.push(stack.pop() * n);
            } else if (c == '+') {

            } else {
                stack.push(c - '0');
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }

    // 分治 + 记忆化 获取所有错误答案
    public Set<Integer> getErrorAnswers(String s) {
        Set<Integer> answers = new HashSet<>();
        if (s.length() == 1) {
            answers.add(s.charAt(0) - '0');
            return answers;
        }

        if (mem.containsKey(s)) {
            return mem.get(s);
        }

        for (int i = 1; i < s.length(); i += 2) {
            char c = s.charAt(i);

            Set<Integer> leftSet = getErrorAnswers(s.substring(0, i));
            Set<Integer> rightSet = getErrorAnswers(s.substring(i + 1));

            for (int left : leftSet) {
                for (int right : rightSet) {
                    int val = (c == '*') ? left * right : left + right;
                    if (val <= 1000) { // 答案外的值不保存
                        answers.add(val);
                    }
                }
            }
        }

        mem.put(s, answers);
        return answers;
    }

    public int scoreOfStudents(String s, int[] answers) {
        mem = new HashMap<>();
        Set<Integer> errAnsSet = getErrorAnswers(s);
        int validAns = calc(s);
        //System.out.println("validAns: " + validAns);

        int res = 0;
        for (int ans : answers) {
            if (ans == validAns) {
                res += 5;
            } else if (errAnsSet.contains(ans)) {
                res += 2;
            }
        }

        return res;
    }
}
