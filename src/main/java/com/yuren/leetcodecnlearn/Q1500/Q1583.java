package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-07 03:12
 */
public class Q1583 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int result = 0, match[] = new int[n];
        for (int[] pair : pairs) {
            match[pair[0]] = pair[1];
            match[pair[1]] = pair[0];
        }
        for (int i = 0; i < n; i++) {
            if (helper(i, match, preferences)) {
                ++result;
            }
        }
        return result;
    }

    private boolean helper(int x, int[] match, int[][] preferences) {
        int y = match[x];
        for (int u : preferences[x]) {
            if (u == y) {
                break;
            }
            for (int v : preferences[u]) {
                if (v == match[u]) {
                    break;
                }
                if (v == x) {
                    return true;
                }
            }
        }
        return false;
    }
}
