package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-22 23:23
 */
public class Q1163 {
    public String lastSubstring(String s) {
        int i = 0, j = 1, n = s.length(), len = 0;
        char[] arr = s.toCharArray();
        while (j < n) {
            if (arr[i] > arr[j]) {
                j++;
            } else if (arr[i] < arr[j]) {
                i = j++;
            } else {
                len = 1;
                while (j + len < n && arr[i + len] == arr[j + len]) len++;
                if (j + len == n) return s.substring(i);
                if (arr[i + len] > arr[j + len]) {
                    j += len + 1;
                } else if (arr[i] < arr[j + len]) {
                    i = j + len;
                    j += len + 1;
                } else {
                    i = j++;
                }
            }
        }
        return s.substring(i);
    }
}
