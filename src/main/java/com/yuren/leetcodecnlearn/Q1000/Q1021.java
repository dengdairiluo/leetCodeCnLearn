package com.yuren.leetcodecnlearn.Q1000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-03-07 11:20
 */
public class Q1021 {


    private static String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') {
                --level;
            }
            if (level >= 1) {
                sb.append(c);
            }
            if (c == '(') {
                ++level;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("()()()(()())"));
    }
}
