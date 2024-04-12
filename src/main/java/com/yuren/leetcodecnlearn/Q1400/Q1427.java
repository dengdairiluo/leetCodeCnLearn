package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-05 22:24
 */
public class Q1427 {
    public String stringShift(String s, int[][] shift) {
        int move = 0;
        for (int[] operation : shift) {
            if (operation[0] == 0) {
                move -= operation[1];
            } else {
                move += operation[1];
            }
        }
        while (move > 0) {
            move -= s.length();
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int loc = (i - move + s.length()) % s.length();
            builder.append(s.charAt(loc));
        }
        return builder.toString();
    }
}
