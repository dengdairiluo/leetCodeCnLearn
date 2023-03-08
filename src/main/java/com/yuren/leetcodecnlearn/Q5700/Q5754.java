package com.yuren.leetcodecnlearn.Q5700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-05-30 23:13
 */
public class Q5754 {
    public int countGoodSubstrings(String s) {
        int ans = 0;
        char[] three = new char[3];
        for (int i = 0; i < s.length(); i++) {
            three[i % 3] = s.charAt(i);
            if (i > 1 && three[0] != three[1] && three[1] != three[2] && three[0] != three[2]) {
                ans++;
            }
        }
        return ans;


    }
}
