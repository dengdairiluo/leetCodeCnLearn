package com.yuren.leetcodecnlearn.Q2300;

import com.yuren.leetcodecnlearn.entity.ListNode;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-31 21:49
 */
public class Q2326 {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        if (m == 1 && n == 1) {
            return new int[][]{{head.val}};
        }

        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], -1);
        }

        ListNode p = head;
        int offset = 1, startX = 0, startY = 0;
        int loop = m / 2;
        while (loop >= 0) {

            int i = startX, j = startY;

            for (; j < res[0].length - offset; j++) {
                res[i][j] = p.val;
                p = p.next;
                if (p == null) {
                    return res;
                }
            }

            for (; i < res.length - offset; i++) {
                res[i][j] = p.val;
                p = p.next;
                if (p == null) {
                    return res;
                }
            }

            for (; j > startX; j--) {
                res[i][j] = p.val;
                p = p.next;
                if (p == null) {
                    return res;
                }
            }

            for (; i > startY; i--) {
                res[i][j] = p.val;
                p = p.next;
                if (p == null) {
                    return res;
                }
            }

            startX++;
            startY++;
            offset++;
            loop--;
        }

        if (m == n && m % 2 != 0) {
            res[m / 2][n / 2] = p.val;
        }


        return res;
    }
}
