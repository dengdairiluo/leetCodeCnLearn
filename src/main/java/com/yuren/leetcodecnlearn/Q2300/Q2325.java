package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-29 23:55
 */
public class Q2325 {
    public String decodeMessage(String key, String message) {
        char[] chs = key.toCharArray();
        //密码本字母下标对应的原始字母。
        char[] dict = new char[26];
        int idx = 0;
        for (char cr : chs) {
            if (cr == ' ') {
                continue;
            }
            int i = cr - 'a';
            if (dict[i] == 0) {
                dict[i] = (char) (idx + 'a');
                idx++;
            }
        }

        char[] source = message.toCharArray();
        char[] res = new char[source.length];
        int ri = 0;
        for (char s : source) {
            res[ri] = ' ' == s ? ' ' : dict[s - 'a'];
            ri++;
        }
        return new String(res);
    }
}
