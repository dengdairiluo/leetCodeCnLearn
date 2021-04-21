package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.List;

public class Q1213 {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int[] bucket = new int[2001];

        for (int arr : arr1) {
            bucket[arr]++;
        }

        for (int arr : arr2) {
            bucket[arr]++;
        }

        for (int arr : arr3) {
            bucket[arr]++;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < 2000; i++) {
            if (bucket[i] == 3) {
                ans.add(i);
            }
        }
        return ans;
    }

}
