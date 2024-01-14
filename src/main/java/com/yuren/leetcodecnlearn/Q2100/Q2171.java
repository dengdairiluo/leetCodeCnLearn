package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-14 22:50
 */
public class Q2171 {
    private static final int LEN = 100001;

    public long minimumRemoval(int[] beans) {
        int[] index = new int[LEN];
        int n = beans.length;
        long maxSub = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += beans[i];
            index[beans[i]]++;
        }
        for (int i = 1; i < LEN; i++) {
            if (index[i] == 0) {
                continue;
            }
            long cnt = (long) i * n;
            if (cnt > maxSub) {
                maxSub = cnt;
            }
            n -= index[i];
        }
        return sum - maxSub;
    }

}
