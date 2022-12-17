package com.yuren.leetcodecnlearn.Q900;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-31 22:12
 */
public class Q899 {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String ans = s;
            for (int i = 0; i < s.length(); ++i) {
                String t = s.substring(i) + s.substring(0, i);
                if (t.compareTo(ans) < 0) {
                    ans = t;
                }
            }
            return ans;
        } else {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            return new String(ca);
        }
    }
}
