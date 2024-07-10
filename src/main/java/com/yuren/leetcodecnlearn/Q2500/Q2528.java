package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-11 上午12:28
 */
public class Q2528 {
    public long maxPower(int[] stations, int r, int k) {

        // 二分 + 差分
        int n = stations.length;
        long[] diff = new long[n];
        for (int i = 0; i < n; i++) {
            if (i - r <= 0) {
                diff[0] += stations[i];
            } else {
                diff[i - r] += stations[i];
            }
            if (i + r + 1 < n) {
                diff[i + r + 1] -= stations[i];
            }
        }

        long[] elecs = new long[n];
        long pre = 0l;
        long left = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            // elecs[i] = pre + diff[i];
            pre += diff[i];
            elecs[i] = pre;
            left = Math.min(left, elecs[i]);
            // System.out.print(elecs[i] + " ");
        }
        System.out.println();
        System.out.println(left);


        long right = left + k;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (check(elecs, r, k, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return right;

    }

    public boolean check(long[] elecs, int r, int k, long min) {
        int[] dif = new int[elecs.length];
        int d = 0;
        for (int i = 0; i < elecs.length; i++) {
            d += dif[i];
            if (elecs[i] + d < min) {
                long offset = min - elecs[i] - d;
                k -= (int) offset;
                d += (int) offset;
                if (i + 2 * r + 1 < elecs.length) {
                    dif[i + 2 * r + 1] -= (int) offset;
                }
            }

            if (k < 0) {
                return false;
            }
        }

        return true;

    }


}
