package com.yuren.leetcodecnlearn.Q1500;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-08 00:34
 */
public class Q1585 {
    public boolean isTransformable(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        int n = s.length();
        Queue<Integer>[] pos = new Queue[10];
        for (int i = 0; i < 10; i++) {
            pos[i] = new ArrayDeque<>();
        }
        for (int i = 0; i < n; i++) {
            pos[s.charAt(i) - '0'].add(i);
        }
        for (int i = 0; i < n; i++) {
            int digit = t.charAt(i) - '0';
            if (pos[digit].isEmpty()) {
                return false;
            }
            for (int j = 0; j < digit; j++) {
                if (!pos[j].isEmpty() && pos[j].peek() < pos[digit].peek()) {
                    return false;
                }
            }
            pos[digit].poll();
        }
        return true;
    }
}
