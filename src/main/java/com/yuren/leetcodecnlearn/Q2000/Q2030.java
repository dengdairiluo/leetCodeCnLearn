package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-03 23:46
 */
public class Q2030 {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        if (s.length() == k) {
            return s;
        }
        int n = s.length();
        int delete = n - k;
        int top = -1;

        char[] c = s.toCharArray();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (c[i] == letter) {
                count++;
            }
        }
        for (int i = 0; i < n; i++) {

            while (top >= 0 && delete > 0 && c[top] > c[i]) {

                if (c[top] == letter && count > repetition) {
                    count--;
                } else if (c[top] == letter && count <= repetition) {
                    break;
                }
                top--;
                delete--;
            }
            top++;
            c[top] = c[i];
        }

        count = 0;
        for (int i = 0; i < k; i++) {
            if (c[i] == letter) {
                count++;
            }
        }

        for (int i = k - 1; i >= 0; i--) {
            if (count < repetition && c[i] != letter) {
                c[i] = letter;
                count++;
            }
        }
        String s1 = new String(c);
        return s1.substring(0, k);
    }
}
