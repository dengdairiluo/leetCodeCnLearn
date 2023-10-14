package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-15 00:08
 */
public class Q1989 {
    /**
     * 双指针。先用一个指针遍历找到数组中的每一个1，然后求出
     * 这个1的查找范围，然后在这个范围内，去查找0，因为每一个1
     * 只能找1个0，并且寻找1的过程时从左往右的，所以优先找左侧的0，
     * 也就是从左向右找。找到后就去下一个1寻找
     */
    public int catchMaximumAmountofPeople(int[] team, int dist) {
        int zero = 0, res = 0, n = team.length;
        for (int i = 0; i < n; i++) {
            if (team[i] == 1) {
                int left = Math.max(0, i - dist);
                int right = Math.min(n - 1, i + dist);
                zero = Math.max(zero, left);
                while (zero <= right && team[zero] != 0) {
                    zero++;
                }
                if (zero <= right) {
                    res++;
                    zero++;
                }
            }
        }
        return res;
    }
}
