package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-24 23:38
 */
public class Q1881 {
    public String maxValue(String n, int x) {
        char cx = (char) ('0' + x);
        StringBuilder sb = new StringBuilder(n);
        int l = sb.length(), i = 0;
        if (sb.charAt(0) == '-') {
            for (i = 1; i < l; i++) {
                if (n.charAt(i) > cx) break;
            }
        } else {
            for (; i < l; i++) {
                if (n.charAt(i) < cx) break;
            }
        }
        return sb.insert(i, cx).toString();
    }
}
