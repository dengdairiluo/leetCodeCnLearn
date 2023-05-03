package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-03 23:27
 */
public class Q1576 {
    public String modifyString(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; ++i) {
            if (arr[i] == '?') {
                for (char ch = 'a'; ch <= 'c'; ++ch) {
                    if ((i > 0 && arr[i - 1] == ch) || (i < n - 1 && arr[i + 1] == ch)) {
                        continue;
                    }
                    arr[i] = ch;
                    break;
                }
            }
        }
        return new String(arr);
    }
}
