package com.yuren.leetcodecnlearn.Q1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-27 23:35
 */
public class Q1243 {
    public static List<Integer> transformArray(int[] arr) {
        int len = arr.length;
        boolean feed = true;
        while (feed) {
            feed = false;
            int a[] = Arrays.copyOf(arr, len);
            for (int i = 1; i < len - 1; i++) {
                if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    a[i]++;
                    feed = true;
                } else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    a[i]--;
                    feed = true;
                }
            }
            arr = a;
        }
        return intArrayToList(arr);
    }

    public static List<Integer> intArrayToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int j : arr) {
            list.add(j);
        }
        return list;
    }

}
