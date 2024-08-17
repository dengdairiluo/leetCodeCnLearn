package com.yuren.leetcodecnlearn.Q2600;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-18 01:56
 */
public class Q2604 {
    public int minimumTime(int[] hens, int[] grains) {
        Arrays.sort(hens);
        Arrays.sort(grains);
        int n = hens.length, m = grains.length;
        int low = 0, high = hens[n - 1] + grains[m - 1];
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canEatAllGrains(hens, grains, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean canEatAllGrains(int[] hens, int[] grains, int time) {
        int n = hens.length, m = grains.length;
        int j = 0;
        for (int i = 0; i < n && j < m; i++) {
            int left = hens[i], right = hens[i];
            boolean flag = true;
            while (j < m && flag) {
                left = Math.min(left, grains[j]);
                right = Math.max(right, grains[j]);
                if (Math.min(hens[i] - left, right - hens[i]) + right - left <= time) {
                    j++;
                } else {
                    flag = false;
                }
            }
        }
        return j == m;
    }

}
