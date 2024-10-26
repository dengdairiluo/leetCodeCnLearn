package com.yuren.leetcodecnlearn.Q2700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-26 22:06
 */
public class Q2744 {
    public int maximumNumberOfStringPairs(String[] words) {
        int ans = 0;
        boolean[][] seen = new boolean[26][26];
        for (String s : words) {
            int x = s.charAt(0) - 'a';
            int y = s.charAt(1) - 'a';
            if (seen[y][x]) {
                // s 和 seen 中的 y+x 匹配
                ans++;
            } else {
                seen[x][y] = true;
            }
        }
        return ans;
    }
}
