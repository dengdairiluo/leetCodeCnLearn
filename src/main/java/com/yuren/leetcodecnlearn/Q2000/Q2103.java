package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-10 00:00
 */
public class Q2103 {
    public int countPoints(String s) {
        int n = s.length(), ans = 0;
        int[] map = new int[128];
        for (int i = 0; i < n; i += 2) map[s.charAt(i) - 'B'] |= 1 << (s.charAt(i + 1) - '0');
        for (int i = 0; i < 10; i++) {
            int tot = 0;
            for (char c : new char[]{'R', 'G', 'B'}) tot += (map[c - 'B'] >> i) & 1;
            if (tot == 3) ans++;
        }
        return ans;
    }

}
