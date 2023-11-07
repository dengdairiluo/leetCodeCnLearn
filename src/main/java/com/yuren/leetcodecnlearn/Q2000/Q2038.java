package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-07 23:50
 */
public class Q2038 {
    public boolean winnerOfGame(String colors) {
        char[] cs = colors.toCharArray();
        int n = cs.length;
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && cs[j] == cs[i]) j++;
            if (j - i >= 3) {
                if (cs[i] == 'A') a += j - i - 2;
                else b += j - i - 2;
            }
            i = j - 1;
        }
        return a > b;
    }
}
