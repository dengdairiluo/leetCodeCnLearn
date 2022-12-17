package com.yuren.leetcodecnlearn.Q1000;

import java.util.Arrays;
import java.util.Random;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-05 23:54
 */
public class Q973 {
    private final Random rand = new Random();

    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        randomSelect(points, 0, n - 1, k);
        return Arrays.copyOfRange(points, 0, k);
    }

    public void randomSelect(int[][] points, int left, int right, int k) {
        int pivotId = left + rand.nextInt(right - left + 1);
        int pivot = points[pivotId][0] * points[pivotId][0] + points[pivotId][1] * points[pivotId][1];
        swap(points, right, pivotId);
        int i = left - 1;
        for (int j = left; j < right; ++j) {
            int dist = points[j][0] * points[j][0] + points[j][1] * points[j][1];
            if (dist <= pivot) {
                ++i;
                swap(points, i, j);
            }
        }
        ++i;
        swap(points, i, right);
        // [left, i-1] 都小于等于 pivot, [i+1, right] 都大于 pivot
        if (k < i - left + 1) {
            randomSelect(points, left, i - 1, k);
        } else if (k > i - left + 1) {
            randomSelect(points, i + 1, right, k - (i - left + 1));
        }
    }

    public void swap(int[][] points, int index1, int index2) {
        int[] temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }
}
