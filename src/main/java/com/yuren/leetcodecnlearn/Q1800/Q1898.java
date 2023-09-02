package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-02 22:03
 */
public class Q1898 {
    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0;
        int right = removable.length - 1;
        int mid;
        char[] s1 = s.toCharArray();
        char[] p1 = p.toCharArray();
        while (left <= right) {
            mid = (left + right) >> 1;
            toggle(s1, removable, left, mid);
            if (isIn(s1, p1)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            toggle(s1, removable, left, mid);
            // s1=s.toCharArray();
        }
        return left;
    }

    public boolean isIn(char[] s, char[] p) {
        int pc = 0;
        if (s.length < p.length) {
            return false;
        }
        for (int i = 0; i < s.length; i++) {
            if (p[pc] == s[i]) {
                pc++;
            }
            if (pc >= p.length) {
                return true;
            }
        }
        return false;
    }

    /**
     * 这个函数用于标记从left到right的removable节点的移除/放回
     */
    public void toggle(char[] s, int[] removable, int left, int right) {
        for (int i = left; i <= right; i++) {
            s[removable[i]] ^= 0b111000;
        }
    }
}
