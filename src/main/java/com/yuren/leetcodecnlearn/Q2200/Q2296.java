package com.yuren.leetcodecnlearn.Q2200;

import java.util.Stack;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-15 23:49
 */
public class Q2296 {

    public Q2296() {
        a = new Stack<>();
        b = new Stack<>();
    }

    Stack<Character> a, b;

    public void addText(String text) {
        char[] array = text.toCharArray();
        for (char c : array) {
            a.push(c);
        }
    }

    public int deleteText(int k) {
        int target = k;
        while (k > 0 && !a.isEmpty()) {
            a.pop();
            k--;
        }
        return target - k;
    }

    public String cursorLeft(int k) {
        while (!a.isEmpty() && k > 0) {
            b.push(a.pop());
            k--;
        }
        return readLeftChar();
    }

    private String readLeftChar() {
        if (a.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        while (sb.length() < 10 && !a.isEmpty()) {
            sb.append(a.pop());
        }
        String rs = sb.reverse().toString();
        addText(rs);
        return rs;
    }

    public String cursorRight(int k) {

        while (!b.isEmpty() && k > 0) {
            a.push(b.pop());
            k--;
        }
        return readLeftChar();
    }
}
