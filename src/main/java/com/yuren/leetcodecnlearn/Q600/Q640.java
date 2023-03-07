package com.yuren.leetcodecnlearn.Q600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-09 23:34
 */
public class Q640 {
    public static String solveEquation(String equation) {
        char[] chars = equation.toCharArray();
        //  x数量  常数和                           单位        遇到等于符号反转
        int x = 0, result = 0, length = chars.length, symbol = 1, eq = 1;
        for (int i = 0; i < length; i++) {
            char c = chars[i];
            int k = c - '0';
            switch (c) {
                case '+':
                    symbol = eq;
                    break;
                case '-':
                    symbol = -eq;
                    break;
                case '=':
                    eq = -1;
                    symbol = eq;
                    break;
                case 'x':
                    x += symbol;
                    break;
                default:
                    int z = k, j = i + 1;
                    for (; j < length; j++) {
                        if (chars[j] == 'x') {
                            x += z * symbol;
                            j = j + 1;
                            z = 0;
                            break;
                        }
                        k = chars[j] - '0';
                        if (k >= 0 && k <= 9) {
                            z = z * 10 + k;
                        } else {
                            break;
                        }
                    }
                    i = j - 1;
                    if (z != 0) result += z * symbol;
            }
        }
        if (x == 0 && result == 0) return "Infinite solutions";
        if (x == 0) return "No solution";
        return "x=" + -(result / x);
    }
}
