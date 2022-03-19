package com.yuren.leetcodecnlearn;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-03-19 21:55
 */
public class Q593 {
    int distance(int[] start, int[] end) {
        return (start[0] - end[0]) * (start[0] - end[0]) + (start[1] - end[1]) * (start[1] - end[1]);
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int data1 = distance(p1, p2), data2 = distance(p2, p3), data3 = distance(p3, p4);
        int data4 = distance(p1, p3), data5 = distance(p2, p4), data6 = distance(p1, p4);
        int[] ans = new int[]{data1, data2, data3, data4, data5, data6};
        Arrays.sort(ans);
        if (ans[0] > 0 && ans[0] == ans[1] && ans[1] == ans[2] && ans[2] == ans[3] &&
                ans[0] * 2 == ans[4] && ans[0] * 2 == ans[5]) {
            return true;
        }
        return false;
    }
}
