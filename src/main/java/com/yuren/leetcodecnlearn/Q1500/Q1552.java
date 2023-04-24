package com.yuren.leetcodecnlearn.Q1500;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-24 23:51
 */
public class Q1552 {
    public int maxDistance(int[] position, int m) {

        Arrays.sort(position);
        int n = position.length;

        int left = 0, right = (position[n - 1] - position[0]) / (m - 1);
        int result = 0;
        while (left <= right) {
            int mid = right - (right - left) / 2;
            if (check(position, m, mid)) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private boolean check(int[] position, int m, int distance) {
        int count = 1, cur = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - cur >= distance) {
                cur = position[i];
                count++;
                if (count >= m) {
                    return true;
                }
            }
        }
        return false;
    }
}
