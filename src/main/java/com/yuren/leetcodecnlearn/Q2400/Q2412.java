package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-14 下午11:19
 */
public class Q2412 {
    public long minimumMoney(int[][] transactions) {
        long totalLose = 0L;
        int mx = 0;
        for (int[] t : transactions) {
            totalLose += Math.max(t[0] - t[1], 0);
            mx = Math.max(mx, Math.min(t[0], t[1]));
        }
        return totalLose + mx;
    }
}
