package com.yuren.leetcodecnlearn.Q1600;

import static java.nio.charset.StandardCharsets.ISO_8859_1;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-03 23:41
 */
public class Q1653 {
    public int minimumDeletions(String s) {
        int nb = 0, del = 0;
        for (byte c : s.getBytes(ISO_8859_1)) {
            del = Math.min(del + (c - 'a' ^ 1), nb += c - 'a');
        }
        return del;
    }
}
