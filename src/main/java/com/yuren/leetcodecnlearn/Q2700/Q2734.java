package com.yuren.leetcodecnlearn.Q2700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-21 23:39
 */
public class Q2734 {
    public String smallestString(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        for (int i = 0; i < n; i++) {
            if (s[i] > 'a') {
                // 继续向后遍历
                for (; i < n && s[i] > 'a'; i++) {
                    s[i]--;
                }
                return new String(s);
            }
        }
        // 所有字母均为 a
        s[n - 1] = 'z';
        return new String(s);
    }
}
