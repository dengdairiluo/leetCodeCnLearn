package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-15 23:34
 */
public class Q1694 {
    public String reformatNumber(String number) {
        String s = number.replace(" ", "").replace("-", "");
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i += 3) {
            if (sb.length() != 0) {
                sb.append("-");
            }
            if (i + 5 > n) {
                if (i + 3 >= n) {
                    sb.append(s.substring(i));
                } else {
                    sb.append(s, i, i + 2).append("-").append(s.substring(i + 2));
                }
                break;
            }
            sb.append(s, i, i + 3);
        }
        return sb.toString();
    }
}
