package com.yuren.leetcodecnlearn.Q1000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-26 23:44
 */
public class Q1033 {
    public int[] numMovesStones(int a, int b, int c) {
        // a b c先按顺序排一下, 冒泡排序
        if (a > b) {
            a = a + b;
            b = a - b;
            a = a - b;
        }
        if (b > c) {
            c = b + c;
            b = c - b;
            c = c - b;
        }
        if (a > b) {
            a = a + b;
            b = a - b;
            a = a - b;
        }

        int[] ans = new int[2];
        if (b != a + 1) ++ans[0];
        if (c != b + 1) ++ans[0];
        if (b - a == 2 || c - b == 2) ans[0] = 1;

        ans[1] = c - a - 2;
        return ans;
    }
}
