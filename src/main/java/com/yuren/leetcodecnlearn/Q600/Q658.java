package com.yuren.leetcodecnlearn.Q600;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-17 23:29
 */
public class Q658 {
    /**
     * 滑动窗口，大小固定为连续的k*
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int n = arr.length - k;
        int i = 0;
        for (; i < n; i++) {
            //最小的数大于x
            if (arr[i] >= x) break;
            //最的大数小于x
            if (arr[i + k] < x) continue;
            if (Math.abs(arr[i] - x) <= Math.abs(arr[i + k] - x)) break;
        }
        for (int j = 0; j < k; j++) {
            list.add(arr[j + i]);
        }
        return list;
    }
}
