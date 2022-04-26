package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-26 22:55
 */
public class Q678 {
    public boolean checkValidString(String s) {
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++;
                r++;
            } else if (c == ')') {
                l--;
                r--;
            } else {
                l--;
                r++;
            }
            l = Math.max(l, 0);
            if (l > r) return false;
        }
        return l == 0;
    }
}
