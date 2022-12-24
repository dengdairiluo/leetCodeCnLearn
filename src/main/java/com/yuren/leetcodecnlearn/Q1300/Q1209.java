package com.yuren.leetcodecnlearn.Q1300;

import java.util.Stack;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-11 22:32
 */
public class Q1209 {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> counts = new Stack<>();
        for (int i = 0; i < sb.length(); ++i) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                counts.push(1);
            } else {
                int incremented = counts.pop() + 1;
                if (incremented == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    counts.push(incremented);
                }
            }
        }
        return sb.toString();
    }
}
