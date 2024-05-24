package com.yuren.leetcodecnlearn.Q2400;

import java.util.LinkedList;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-24 下午11:55
 */
public class Q2434 {
    public String robotWithString(String s) {
        // dabea
        int len = s.length();
        LinkedList<Character> st = new LinkedList();
        StringBuilder res = new StringBuilder();
        char[] hm = s.toCharArray();
        for (int i = len - 2; i >= 0; i--) {
            if (hm[i] > hm[i + 1]) hm[i] = hm[i + 1];
        }
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            while (!st.isEmpty() && st.getLast() <= hm[i]) {
                res.append(st.removeLast());
            }
            if (hm[i] < c) {
                st.add(c);
            } else {
                res.append(c);
            }
        }
        while (!st.isEmpty()) {
            res.append(st.removeLast());
        }
        return res.toString();

    }
}

