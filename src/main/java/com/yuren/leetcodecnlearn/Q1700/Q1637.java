package com.yuren.leetcodecnlearn.Q1700;

import java.util.Arrays;
import java.util.Comparator;

public class Q1637 {

    public int maxWidthOfVerticalArea1(int[][] points) {
        int[] arr = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            arr[i] = points[i][0];
        }

        Arrays.sort(arr);
        int ans = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            ans = Math.max(ans, arr[i + 1] - arr[i]);
        }
        return ans;
    }

    public int maxWidthOfVerticalArea2(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int ans = 0;
        for (int i = 0; i < points.length - 1; i++) {
            ans = Math.max(ans, points[i + 1][0] - points[i][0]);
        }
        return ans;
    }
}
