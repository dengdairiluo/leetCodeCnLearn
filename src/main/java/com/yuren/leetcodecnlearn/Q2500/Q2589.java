package com.yuren.leetcodecnlearn.Q2500;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-10 23:41
 */
public class Q2589 {
    public int findMinimumTime(int[][] tasks) {
        int n = tasks.length;
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[1]));
        int[] run = new int[tasks[n - 1][1] + 1];
        int res = 0;
        for (int[] task : tasks) {
            int start = task[0], end = task[1], duration = task[2];
            for (int j = start; j <= end; j++) {
                duration -= run[j];
            }
            res += Math.max(duration, 0);
            for (int j = end; j >= 0 && duration > 0; j--) {
                if (run[j] == 0) {
                    duration--;
                    run[j] = 1;
                }
            }
        }
        return res;
    }
}
