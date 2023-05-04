package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-04 23:07
 */
public class Q1578 {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        char[] chars = colors.toCharArray();
        int res = 0;
        char a = chars[0];
        int at = neededTime[0];
        for (int i = 1; i < n; i++) {
            char b = chars[i];
            int bt = neededTime[i];
            if (a == b) {
                res += Math.min(at, bt);
                at = Math.max(at, bt);
            } else {
                a = b;
                at = bt;
            }
        }
        return res;
    }
}
