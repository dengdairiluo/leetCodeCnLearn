package com.yuren.leetcodecnlearn.Q500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-01-08 23:38
 */
public class Q439 {
    public String parseTernary(String expression) {
        int n = expression.length();
        int checkLevel = 0;
        for (int j = 1; j < n; j++) {
            if (expression.charAt(j) == '?') {
                checkLevel++;
            }
            if (expression.charAt(j) == ':') {
                checkLevel--;
            }
            if (checkLevel == 0) {
                return (expression.charAt(0) == 'T') ? parseTernary(expression.substring(2, j)) : parseTernary(expression.substring(j + 1, n));
            }
        }
        return expression;
    }
}
