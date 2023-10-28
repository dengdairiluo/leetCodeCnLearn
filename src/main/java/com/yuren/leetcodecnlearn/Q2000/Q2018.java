package com.yuren.leetcodecnlearn.Q2000;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-28 23:34
 */
public class Q2018 {
    public boolean placeWordInCrossword(char[][] board, String word) {
        for (char[] chars : board) {
            if (check(chars, word)) {
                return true;
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            int m = board.length;
            char[] str = new char[m];
            for (int j = 0; j < m; j++) {
                str[j] = board[j][i];
            }
            if (check(str, word)) {
                return true;
            }
        }
        return false;
    }

    boolean check(char[] str, String w) {
        int n = w.length();
        if (n > str.length) {
            return false;
        }
        List<Integer> a = new ArrayList<>();
        a.add(-1);
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '#') {
                a.add(i);
            }
        }
        a.add(str.length);
        for (int i = 0; i < a.size() - 1; i++) {
            int x = a.get(i);
            int y = a.get(i + 1);
            if (y - x - 1 == n) {
                int k = 0;
                boolean flag = true;
                for (int j = x + 1; j <= y - 1; j++) {
                    if (str[j] == ' ' || str[j] == w.charAt(k)) {
                        k++;
                    } else {
                        flag = false;
                        break;
                    }
                }
                k = 0;
                boolean fFlag = true;
                for (int j = x + 1; j <= y - 1; j++) {
                    if (str[j] == ' ' || str[j] == w.charAt(w.length() - k - 1)) {
                        k++;
                    } else {
                        fFlag = false;
                        break;
                    }
                }
                if (flag || fFlag) {
                    return true;
                }
            }
        }
        return false;
    }
}
