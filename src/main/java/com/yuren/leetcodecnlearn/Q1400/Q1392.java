package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-20 23:44
 */
public class Q1392 {
    public String longestPrefix(String s) {
        if (s.length() < 2) {
            return "";
        }
        int[] next = getNext(s);
        //System.out.println(Arrays.toString(next));
        return s.substring(0, next[s.length()]);
    }

    private int[] getNext(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] next = new int[n + 1];
        next[0] = -1;
        next[1] = 0;
        int i = 2, j = 0;
        while (i <= n) {
            if (chars[i - 1] == chars[j]) {
                next[i++] = ++j;
            } else if (j > 0) {
                j = next[j];
            } else {
                i++;
            }
        }
        return next;
    }

    private int[] getNext2(String s) {
        int n = s.length();
        int[] next = new int[n + 1];
        next[0] = -1;
        next[1] = 0;
        int j = 2;
        int cnt = 0;
        for (int i = 2; i <= n; ) {
            if (s.charAt(i - 1) == s.charAt(cnt)) {
                next[i++] = ++cnt;
            } else if (cnt != 0) {
                cnt = next[cnt];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
