package com.yuren.leetcodecnlearn.Q1200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-05 00:11
 */
public class Q1249 {
    public String minRemoveToMakeValid(String s) {
        char[] stack = new char[s.length()];
        int si = 0;
        char[] ret = new char[s.length()];
        int ri = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                if (c == '(') {
                    stack[si++] = c;
                    ret[ri++] = c;
                } else {
                    if (si == 0) {
                        continue;
                    } else if (stack[si - 1] == '(') {
                        stack[--si] = 0;
                        ret[ri++] = c;
                    }
                }
            } else {
                ret[ri++] = c;
            }
        }
        if (si > 0) {
            int size = si;
            for (int i = ri - 1; i >= 0 && size > 0; i--) {
                if (ret[i] == '(') {
                    ret[i] = 0;
                    size--;
                }
            }
            for (int i = 0; i < ri - 1; i++) {
                int t = i;
                while (ret[i] == 0 && t + 1 < ri) {
                    ret[i] = ret[t + 1];
                    ret[t + 1] = 0;
                    t++;
                }
            }
            ri -= si;
        }
        return new String(ret, 0, ri);
    }
}
