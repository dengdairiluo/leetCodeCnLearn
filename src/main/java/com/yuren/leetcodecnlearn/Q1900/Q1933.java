package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-17 20:36
 */
public class Q1933 {
    public boolean isDecomposable(String s) {
        char[] cArray = s.toCharArray();
        int n = s.length();
        int i = 0;
        int twos = 0;//出现取余为2的次数
        while (i < n) {
            int j = i + 1;
            while (j < n && cArray[j] == cArray[i]) {
                j++;
            }
            if ((j - i) % 3 == 1) {
                return false;
            }
            if ((j - i) % 3 == 2) {
                twos++;
            }
            i = j;
        }
        return twos == 1;
    }
}
