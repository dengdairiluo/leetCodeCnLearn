package com.yuren.leetcodecnlearn;

public class LCP06 {
    public int minCount(int[] coins) {
        int ans = 0;
        for (int c : coins) {
            if (c < 3) {
              ans++;
            } else {
                ans += (c + 1) / 2;
            }
        }
        return ans;
    }
}
