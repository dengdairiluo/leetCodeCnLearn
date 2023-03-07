package com.yuren.leetcodecnlearn.Q0;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q71 {
    public String simplifyPath(String path) {
        String[] pathArray = path.split("/");
        //分割后的几种情况 空格说明是多出来的/，.. .与目录
        StringBuilder res = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        for (String s : pathArray) {
            //2种情况，栈为空或者栈不为空
            if (s.length() == 0 || s.equals(".")) continue;
            if (!stack.isEmpty()) {
                if (s.equals("..")) {
                    stack.pop();
                } else {
                    stack.push(s);
                }
            } else {
                if (!s.equals("..")) stack.push(s);
            }
        }
        if (stack.isEmpty()) return res.append('/').toString();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
            res.insert(0, '/');
        }
        return res.toString();

    }
}
