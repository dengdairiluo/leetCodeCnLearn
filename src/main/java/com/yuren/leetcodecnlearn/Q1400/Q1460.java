package com.yuren.leetcodecnlearn.Q1400;

import java.util.Arrays;

public class Q1460 {

    public boolean canBeEqual1(int[] target, int[] arr) {
        int[] ton = new int[1001];
        int len = target.length;
        for (int i = 0; i < len; i++) {
            ton[target[i]]++;
            ton[arr[i]]--;
        }
        for (int i : ton) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canBeEqual2(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
}
