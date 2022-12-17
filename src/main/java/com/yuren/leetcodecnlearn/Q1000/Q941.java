package com.yuren.leetcodecnlearn.Q1000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-18 23:41
 */
public class Q941 {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;

        // 递增扫描
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        // 最高点不能是数组的第一个位置或最后一个位置
        if (i == 0 || i == n - 1) {
            return false;
        }

        // 递减扫描
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == n - 1;
    }
}
