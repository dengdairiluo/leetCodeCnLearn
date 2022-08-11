package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-12 01:14
 */
public class Q925 {
    public boolean isLongPressedName(String name, String typed) {
        int m = name.length();
        int n = typed.length();
        if (n < m) {
            return false;
        }
        char[] nameArr = name.toCharArray();
        char[] typedArr = typed.toCharArray();
        int i = 0, j = 0;
        while (i < m || j < n) {
            // 如果i或j越界（在while条件下i、j不可能同时越界），或者i、j指向的值不相等，直接返回false
            if (i >= m || j >= n || typedArr[j] != nameArr[i]) {
                return false;
            }
            // 如果i、j指向的值相等，同时后移
            while (i < m && j < n && typedArr[j] == nameArr[i]) {
                ++j;
                ++i;
            }
            // j指向的值，可能与i指向的前一个值相等
            while (j < n && typedArr[j] == nameArr[i - 1]) {
                ++j;
            }
        }
        return true;
    }
}
