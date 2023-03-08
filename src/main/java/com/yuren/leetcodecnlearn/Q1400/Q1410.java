package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-25 23:36
 */
public class Q1410 {
    public String entityParser(String text) {
        int len = text.length();
        String[] dict = {"quot;", "apos;", "amp;", "gt;", "lt;", "frasl;"};
        String[] dict0 = {"\"", "'", "&", ">", "<", "/"};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == '&') {
                int j = 0;
                for (; j < 6; j++) {
                    if (text.startsWith(dict[j], i + 1)) {
                        i += dict[j].length();
                        res.append(dict0[j]);
                        break;
                    }
                }
                if (j == 6) {
                    res.append("&");
                }
            } else {
                res.append(text.charAt(i));
            }
        }
        return res.toString();
    }
}
