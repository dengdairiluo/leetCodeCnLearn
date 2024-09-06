package com.yuren.leetcodecnlearn.Q2600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-06 23:54
 */
public class Q2645 {
    public int addMinimum(String word) {
        char[] s = word.toCharArray();
        int t = 1;
        for (int i = 1; i < s.length; i++) {
            if (s[i - 1] >= s[i]) { // 必须生成一个新的 abc
                t++;
            }
        }
        return t * 3 - s.length;
    }
}
