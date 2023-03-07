package com.yuren.leetcodecnlearn.Q100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-09-28 23:21
 */
public class Q151 {
    public String reverseWords(String s) {
        char[] c = s.toCharArray();
        int left = 0;
        int right = c.length - 1;
        StringBuilder str = new StringBuilder();
        while (c[left] == ' ') {
            left++;
        }
        while (c[right] == ' ') {
            right--;
        }
        while (left <= right) {
            int index = right;
            while (index >= left && c[index] != ' ') {
                index--;
            }
            for (int i = index + 1; i <= right; i++) {
                str.append(c[i]);
            }
            if (index > left) {
                str.append(' ');
            }
            while (index >= left && c[index] == ' ') {
                index--;
            }
            right = index;
        }
        return str.toString();
    }
}
