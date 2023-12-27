package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-27 23:30
 */
public class Q2138 {
    public String[] divideString(String s, int k, char fill) {
        int len = s.length();
        String[] result = len % k == 0 ? new String[len / k] : new String[len / k + 1];
        for (int i = 0; i < len; i += k) {
            if (len - i < k) {
                StringBuilder sb = new StringBuilder(s.substring(i, len));
                for (int j = 0; j < k - len + i; j++) {
                    sb.append(fill);
                }
                result[i / k] = sb.toString();
            } else {
                result[i / k] = s.substring(i, i + k);
            }
        }
        return result;
    }
}
