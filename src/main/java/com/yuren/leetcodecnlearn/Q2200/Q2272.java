package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-03 23:16
 */
public class Q2272 {
    public int largestVariance(String s) {
        int ans = 0;
        for (int a = 'a'; a <= 'z'; ++a)
            for (int b = 'a'; b <= 'z'; ++b) {
                if (a == b) continue;
                int diff = 0;
                int diffWithB = -s.length();
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == a) {
                        ++diff;
                        ++diffWithB;
                    } else if (s.charAt(i) == b) {
                        diffWithB = --diff;
                        diff = Math.max(diff, 0);
                    }
                    ans = Math.max(ans, diffWithB);
                }
            }
        return ans;
    }
}
