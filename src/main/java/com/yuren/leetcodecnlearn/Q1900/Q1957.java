package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-06 23:44
 */
public class Q1957 {
    public String makeFancyString(String s) {
        int length = s.length();
        if (length <= 2) {
            return s;
        }
        char[] arr = s.toCharArray();
        int index = 1;
        int count = 1;
        char last = s.charAt(0);
        for (int i = 1; i < length; i++) {
            char current = arr[i];
            if (current == last) {
                count++;
                if (count <= 2) {
                    arr[index++] = current;
                }
            } else {
                arr[index++] = current;
                count = 1;
                last = current;
            }
        }
        return new String(arr, 0, index);
    }
}
