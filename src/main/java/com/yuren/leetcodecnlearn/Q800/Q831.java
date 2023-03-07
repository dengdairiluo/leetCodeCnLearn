package com.yuren.leetcodecnlearn.Q800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-01 23:42
 */
public class Q831 {
    public String maskPII(String s) {
        int in = s.indexOf('@');
        if (in > 0) {
            s = s.toLowerCase();
            StringBuilder sb = new StringBuilder(s);
            sb.replace(1, in - 1, "*****");
            s = sb.toString();
        } else {
            s = s.replace("(", "");
            s = s.replace(")", "");
            s = s.replace("+", "");
            s = s.replace("-", "");
            s = s.replace(" ", "");
            int l = s.length();
            if (l == 10) {
                s = "***-***-" + s.substring(6);
            }
            if (l == 11) {
                s = "+*-***-***-" + s.substring(7);
            }
            if (l == 12) {
                s = "+**-***-***-" + s.substring(8);
            }
            if (l == 13) {
                s = "+***-***-***-" + s.substring(9);
            }
        }
        return s;
    }
}
