package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-20 23:55
 */
public class Q1093 {

    public double[] sampleStats(int[] count) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, cnts = 0, mode = 0;
        long sum = 0;
        int len = count.length;
        for (int i = 0; i < len; i++) {
            int cnt = count[i];
            if (cnt != 0) {
                min = Math.min(min, i);
                max = Math.max(max, i);
                sum += (long) cnt * i;
                cnts += cnt;
                if (cnt > count[mode]) {
                    mode = i;
                }
            }
        }
        int mid = (cnts + 1) >> 1;
        double median = 0;
        for (int i = 0; i < len; i++) {
            int cnt = count[i];
            if (cnt != 0) {
                if (mid > cnt) {
                    mid -= cnt;
                } else if (mid == cnt) {
                    if ((cnts & 1) == 1) {
                        median = i;
                    } else {
                        for (int j = i + 1; j < count.length; j++) {
                            if (count[j] != 0) {
                                median = 1d * (i + j) / 2;
                                break;
                            }
                        }
                        break;
                    }
                } else {
                    median = i;
                    break;
                }
            }
        }
        return new double[]{min, max, 1d * sum / cnts, median, mode};
    }
}
