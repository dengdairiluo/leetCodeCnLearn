package com.yuren.leetcodecnlearn.Q1900;

public class Q1822 {

    private static int arraySign1(int[] nums) {
        int cnt = 0;
        for (int num : nums) {
            if (num == 0)
                return 0;
            if (num < 0) {
                cnt++;
            }
        }
        return cnt % 2 == 1 ? -1 : 1;
    }

    private static int arraySign2(int[] nums) {
        int ans = 1;
        for (int num : nums) {
            if (num == 0)
                return 0;
            if (num < 0) {
                ans *= -1;
            }
        }
        return ans;
    }

}
