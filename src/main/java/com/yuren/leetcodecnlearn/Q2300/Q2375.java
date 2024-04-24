package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-25 上午12:00
 */
public class Q2375 {
    public String smallestNumber(String pattern) {
        int i = 0, n = pattern.length();
        char cur = '1';
        char[] ans = new char[n + 1];
        while (i < n) {
            if (i > 0 && pattern.charAt(i) == 'I') ++i;
            for (; i < n && pattern.charAt(i) == 'I'; ++i) ans[i] = cur++;
            int i0 = i;
            while (i < n && pattern.charAt(i) == 'D') ++i;
            for (int j = i; j >= i0; --j) ans[j] = cur++;
        }
        return new String(ans);
    }
}
