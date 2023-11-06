package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-06 23:42
 */
public class Q2037 {
    public int minMovesToSeat(int[] seats, int[] students) {
        sort(seats);
        sort(students);
        int res = 0;
        for (int i = 0; i < seats.length; ++i) {
            res += Math.abs(seats[i] - students[i]);
        }
        return res;
    }

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int left = begin;
            int right = end;
            while (left < right) {
                while (left < right && arr[right] >= arr[begin]) {
                    --right;
                }
                while (left < right && arr[left] <= arr[begin]) {
                    ++left;
                }
                swap(arr, left, right);
            }
            swap(arr, left, begin);
            quickSort(arr, begin, left - 1);
            quickSort(arr, left + 1, end);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
