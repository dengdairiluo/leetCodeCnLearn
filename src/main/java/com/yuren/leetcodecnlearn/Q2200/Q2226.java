package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-09 23:43
 */
public class Q2226 {
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        int left = 0, right = (int) (sum / k);

        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (jkl2(candies, mid, k)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;


    }

    public boolean jkl2(int[] nums, int x, long thr) {
        if (x == 0) {
            return true;
        }
        long res = 0;
        for (int num : nums) {
            res += num / x;
        }
        if (res >= thr) {
            return true;
        } else {
            return false;
        }

    }
}
