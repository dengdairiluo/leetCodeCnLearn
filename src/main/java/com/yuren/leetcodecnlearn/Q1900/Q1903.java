package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-04 23:22
 */
public class Q1903 {
    public String largestOddNumber(String num) {
        int endIndex = 0;
        boolean flag = true;
        for (int i = num.length() - 1; i >= 0; --i) {
            char c = num.charAt(i);
            if ((c - '0') % 2 == 1) {
                endIndex = i;
                flag = false;
                break;
            }
        }
        if (flag) {
            return "";
        }
        return num.substring(0, endIndex + 1);
    }
}
