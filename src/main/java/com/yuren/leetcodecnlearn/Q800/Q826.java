package com.yuren.leetcodecnlearn.Q800;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-06-29 23:33
 */
public class Q826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int N = difficulty.length;
        Point[] jobs = new Point[N];
        for (int i = 0; i < N; ++i) {
            jobs[i] = new Point(difficulty[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(a -> a.x));
        Arrays.sort(worker);

        int ans = 0, i = 0, best = 0;
        for (int skill : worker) {
            while (i < N && skill >= jobs[i].x) {
                best = Math.max(best, jobs[i++].y);
            }
            ans += best;
        }

        return ans;
    }
}
