package com.yuren.leetcodecnlearn.Q1500;

public class Q1442 {
    public int countTriplets(int[] arr) {
        int len = arr.length;
        int ans = 0;

        for (int i = 0; i < len - 1; i++) {
            int sum = 0;
            for (int k = i; k < len; k++) {
                sum ^= arr[k];
                if (sum == 0 && k > i) {
                    ans += (k - i);
                }
            }
        }
        return ans;
    }
}
