package com.yuren.leetcodecnlearn.Q2000;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-23 23:10
 */
public class Q2071 {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {

        int n = tasks.length, m = workers.length;
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int[] dequeue = new int[n];

        int left = 0, right = n;
        while (left <= right) {
            int mid = left + right >> 1;
            if (check(tasks, workers, pills, strength, mid, m - mid, dequeue))
                left = mid + 1;
            else
                right = mid - 1;
        }
        return right;
    }

    private boolean check(int[] tasks, int[] workers, int pills, int strength, int mid, int wi, int[] dequeue) {

        if (wi < 0) return false;

        int ti = 0, left = 0, right = 0;
        final int m = workers.length;
        while (wi < m) {

            int worker = workers[wi];
            if (left < right && worker >= tasks[dequeue[left]]) {
                left++;
                wi++;
                continue;
            }

            boolean taken = false;
            if (left < right || worker < tasks[ti]) {
                if (--pills < 0) return false;
                worker += strength;
                taken = true;
            }

            while (ti < mid && worker >= tasks[ti])
                dequeue[right++] = ti++;

            if (left == right) return false;

            if (taken)
                right--;
            else
                left++;

            wi++;
        }

        return pills >= 0;
    }
}
