package com.yuren.leetcodecnlearn.Q2500;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-24 下午11:56
 */
public class Q2557 {
    public int maxCount(int[] banned, int n, long maxSum) {
        int pre = 1;
        int cnt = 0;
        Arrays.sort(banned);
        for (int ban : banned) {
            if (ban > maxSum) return cnt;
            int count = ban - pre;
            if (count < 0) continue;
            long lastSum = ((long) pre + ban - 1) * (ban - pre) / 2;
            if (lastSum == maxSum) return cnt + count;
            if (lastSum < maxSum) maxSum -= lastSum;
            else {
                count = getV(pre, ban - 1, maxSum);
                return cnt + count;
            }
            pre = ban + 1;
            cnt += count;
        }

        int count = n - pre + 1;
        long lastSum = ((long) pre + n) * (n - pre + 1) / 2;
        if (lastSum > maxSum) count = getV(pre, n, maxSum);
        return cnt + count;
    }

    private int getV(int start, int end, long sum) {
        int left = start;
        int right = end;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            long lastSum = ((long) start + mid) * (mid - start + 1) / 2;
            if (lastSum <= sum) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left - start + 1;
    }
}
