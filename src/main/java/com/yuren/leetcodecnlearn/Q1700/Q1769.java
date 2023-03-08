package com.yuren.leetcodecnlearn.Q1700;

public class Q1769 {
    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];

        int left = 0, right = 0, total = 0;
        if (boxes.charAt(0) == '1') {
            left++;
        }

        for (int i = 1; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                right++;
                total += i;
            }
        }

        ans[0] = total;

        for (int i = 1; i < boxes.length(); i++) {
            total = total + left - right;
            if (boxes.charAt(i) == '1') {
                left++;
                right--;
            }
            ans[i] = total;
        }

        return ans;
    }
}
