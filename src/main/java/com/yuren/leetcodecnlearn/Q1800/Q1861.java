package com.yuren.leetcodecnlearn.Q1800;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-18 23:20
 */
public class Q1861 {
    public char[][] rotateTheBox(char[][] box) {
        int x = box.length;
        int y = box[0].length;
        char[][] chars = new char[y][x];
        for (char[] c : chars) {
            Arrays.fill(c, '.');
        }
        for (int i = 0; i < x; i++) {
            for (int j = y - 1, k = y; j >= 0; j--) {
                if (box[i][j] == '#') {
                    chars[--k][x - i - 1] = '#';
                } else if (box[i][j] == '*') {
                    chars[j][x - i - 1] = '*';
                    k = j;
                }
            }
        }
        return chars;
    }
}
