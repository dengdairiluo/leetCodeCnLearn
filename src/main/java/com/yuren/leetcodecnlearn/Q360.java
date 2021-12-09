package com.yuren.leetcodecnlearn;

public class Q360 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] ret = new int[n];
        int idx = a > 0 ? n - 1 : 0;
        int L = 0, R = n - 1;
        while (L <= R) {
            int v1 = a * nums[L] * nums[L] + b * nums[L] + c;
            int v2 = a * nums[R] * nums[R] + b * nums[R] + c;
            if (a <= 0) {    // 从两边找小的
                if (v1 < v2) {
                    ret[idx] = v1;
                    L++;
                } else {
                    ret[idx] = v2;
                    R--;
                }
                idx++;
            } else {        // 找大的
                if (v1 > v2) {
                    ret[idx] = v1;
                    L++;
                } else {
                    ret[idx] = v2;
                    R--;
                }
                idx--;
            }
        }
        return ret;
    }
}
