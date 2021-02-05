package com.yuren.leetcodecnlearn;

public class Q1295 {

    public int findNumbers1(int[] nums) {
        int cnt = 0;
        for (int num : nums) {
            if ((num >9 && num <100) || (num > 999 && num < 10000) || num == 100000) {
                cnt++;
            }
        }
        return cnt;
    }

    public int findNumbers2(int[] nums) {
        int cnt = 0;
        for (int num : nums) {
            cnt += String.valueOf(num).length() % 2 == 0 ? 1 : 0;
        }
        return cnt;
    }
}
