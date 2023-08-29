package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-29 23:55
 */
public class Q1891 {
    /**
     * 思路：通过二分查找寻找寻找最大长度。如果切割长度为n时可以满足条件，那么n-1也可以满足条件。
     * 绳子最小长度：1
     * 绳子最大长度：sum(ribbons) / k;
     */
    public int maxLength(int[] ribbons, int k) {
        long sum = 0;
        for (int r : ribbons) {
            sum += r;
        }

        if (sum < k) {
            return 0;
        }
        int right = (int) (sum / k);
        int left = 1;
        int result = 1;


        while (left < right) {
            int mid = (left + right + 1) >> 1;

            if (!isValid(ribbons, k, mid)) {
                right = mid - 1;
            } else {
                result = Math.max(result, mid);
                left = mid;
            }
        }
        return result;

    }

    public boolean isValid(int[] ribbons, int k, int len) {
        for (int r : ribbons) {
            k = k - r / len;
        }
        return k <= 0;
    }
}
