package com.yuren.leetcodecnlearn.Q400;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-12-31 23:43
 */
public class Q422 {
    public boolean validWordSquare(List<String> words) {
        if (words == null) {
            return true;
        }
        int size = words.size();
        if (size == 0) {
            return true;
        }
        int j = 0;
        for (String s : words) {
            int n = s.length();
            for (int i = 0; i < n; i++) {
                char c1 = s.charAt(i);
                if (i >= size) {
                    return false;
                }
                String temp = words.get(i);
                int tempL = temp.length();
                if (j >= tempL) {
                    return false;
                }
                char c2 = temp.charAt(j);
                if (c1 != c2) {
                    return false;
                }
            }
            j++;
        }
        return true;
    }
}
