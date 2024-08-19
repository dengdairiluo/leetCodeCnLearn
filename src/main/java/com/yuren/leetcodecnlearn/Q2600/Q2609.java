package com.yuren.leetcodecnlearn.Q2600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-19 23:06
 */
public class Q2609 {
    public int findTheLongestBalancedSubstring(String s) {
        int n = s.length(), idx = 0, ans = 0;
        while (idx < n) {
            int a = 0, b = 0;
            while (idx < n && s.charAt(idx) == '0' && ++a >= 0) idx++;
            while (idx < n && s.charAt(idx) == '1' && ++b >= 0) idx++;
            ans = Math.max(ans, Math.min(a, b) * 2);
        }
        return ans;
    }
}
