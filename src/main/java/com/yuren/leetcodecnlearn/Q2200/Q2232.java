package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-12 21:31
 */
public class Q2232 {
    public String minimizeResult(String expression) {
        int minResult = Integer.MAX_VALUE;
        int leftParenthesis = -1, rightParenthesis = -1;
        int n = expression.length();
        int plusIndex = expression.indexOf('+');
        for (int i = 0; i < plusIndex; i++) {
            int left1 = i == 0 ? 1 : Integer.parseInt(expression.substring(0, i));
            int left2 = Integer.parseInt(expression.substring(i, plusIndex));
            for (int j = plusIndex + 2; j <= n; j++) {
                int right1 = Integer.parseInt(expression.substring(plusIndex + 1, j));
                int right2 = j == n ? 1 : Integer.parseInt(expression.substring(j));
                int result = left1 * (left2 + right1) * right2;
                if (result < minResult) {
                    minResult = result;
                    leftParenthesis = i;
                    rightParenthesis = j;
                }
            }
        }
        return generateResultStr(expression, leftParenthesis, rightParenthesis);
    }

    public String generateResultStr(String expression, int leftParenthesis, int rightParenthesis) {
        StringBuffer sb = new StringBuffer();
        sb.append(expression, 0, leftParenthesis);
        sb.append('(');
        sb.append(expression, leftParenthesis, rightParenthesis);
        sb.append(')');
        sb.append(expression.substring(rightParenthesis));
        return sb.toString();
    }
}
