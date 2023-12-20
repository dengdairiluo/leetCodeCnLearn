package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-20 23:25
 */
public class Q2125 {
    public int numberOfBeams(String[] bank) {
        int res = 0;
        int pre = 0;
        for (String s : bank) {
            int cur = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    cur++;
                }
            }
            if (cur > 0) {
                res += pre * cur;
                pre = cur;
            }
        }

        return res;
    }
}
