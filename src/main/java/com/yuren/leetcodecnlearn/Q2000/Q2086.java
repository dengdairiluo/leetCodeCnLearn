package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-02 23:28
 */
public class Q2086 {
    public int minimumBuckets(String hamsters) {
        char[] ch = hamsters.toCharArray();
        int n = ch.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (ch[i] != 'H') continue;
            if (i + 1 < n && ch[i + 1] == '.') {
                ans++;
                i += 2;
            } else if (i > 0 && ch[i - 1] == '.') {
                ans++;
            } else {
                return -1;
            }
        }
        return ans;
    }
}
