package com.yuren.leetcodecnlearn.Q2600;

import java.util.ArrayDeque;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-02 22:07
 */
public class Q2696 {
    public int minLength(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && (c == 'B' && st.peek() == 'A' || c == 'D' && st.peek() == 'C'))
                st.pop();
            else
                st.push(c);
        }
        return st.size();
    }
}
