package com.yuren.leetcodecnlearn;

public class Q1047 {
    public String removeDuplicates1(String S) {
        if (S.length() == 0) {
            return "";
        }
        StringBuilder stack = new StringBuilder();
        int top = -1;
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            /*
             * top >= 0 表示stack已被初始化(有元素),且顶部字符等于当前遍历的字符
             * 相同则抹除，且指针往后移动
             */
            if (top >= 0 && stack.charAt(top) == chars[i]) {
                stack.deleteCharAt(top);
                --top;
            } else {
                /*
                 * 将字符添加到顶部，指针往前移动
                 */
                stack.append(chars[i]);
                ++top;
            }
        }
        return stack.toString();
    }

    public String removeDuplicates2(String S) {
        int index = -1;
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (index >= 0 && chars[index] == chars[i]) {
                index--;
            } else {
                index++;
                chars[index] = chars[i];
            }
        }
        return String.copyValueOf(chars, 0, index + 1);
    }
}
