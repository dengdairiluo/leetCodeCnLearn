package com.yuren.leetcodecnlearn.Q1300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-18 00:08
 */
public class Q1298 {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = 0;
        int u = status.length, u1 = keys[0].length, u2 = containedBoxes[0].length;
        boolean[] a = new boolean[u];
        for (int i = 0; i < initialBoxes.length; i++) {
            recurse(status, keys, containedBoxes, a, initialBoxes[i]);
        }
        for (int i = 0; i < u; i++) {
            if (a[i] && status[i] == 1) n += candies[i];
        }
        return n;
    }

    public static void recurse(int[] status, int[][] keys, int[][] containedBoxes, boolean[] a, int o) {
        int u = status.length, u1 = keys[o].length, u2 = containedBoxes[o].length;
        for (int j = 0; j < u1; j++) {
            //  int q = keys[o][j];
            status[keys[o][j]] = 1;
        }
        for (int j = 0; j < u2; j++) {
            int q = containedBoxes[o][j];
            a[q] = true;
            int[] q1 = containedBoxes[q];
            int q2 = keys[q].length;
            for (int i = 0; i < q2; i++) {
                status[keys[q][i]] = 1;
            }
            for (int p = 0; p < q1.length; p++) {
                int p1 = q1[p];
                if (!a[p1]) recurse(status, keys, containedBoxes, a, p1);
            }
        }
        a[o] = true;
    }
}
