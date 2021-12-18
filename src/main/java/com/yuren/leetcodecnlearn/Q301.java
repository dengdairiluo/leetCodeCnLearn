package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q301 {
    private final Set<String> set = new HashSet<>();
    private int n, max, len;
    private String s;

    public List<String> removeInvalidParentheses(String s1) {
        s = s1;
        n = s.length();

        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++;
            } else if (c == ')') {
                if (l != 0) l--;
                else r++;
            }
        }
        len = n - l - r;

        int c1 = 0, c2 = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') c1++;
            else if (c == ')') c2++;
        }
        max = Math.min(c1, c2);

        dfs(0, "", l, r, 0);
        return new ArrayList<>(set);
    }

    void dfs(int u, String cur, int l, int r, int score) {
        if (l < 0 || r < 0 || score < 0 || score > max) return;
        if (l == 0 && r == 0) {
            if (cur.length() == len) set.add(cur);
        }
        if (u == n) return;
        char c = s.charAt(u);
        if (c == '(') {
            dfs(u + 1, cur + c, l, r, score + 1);
            dfs(u + 1, cur, l - 1, r, score);
        } else if (c == ')') {
            dfs(u + 1, cur + c, l, r, score - 1);
            dfs(u + 1, cur, l, r - 1, score);
        } else {
            dfs(u + 1, cur + c, l, r, score);
        }
    }
}
