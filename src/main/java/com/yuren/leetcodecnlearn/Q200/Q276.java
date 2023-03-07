package com.yuren.leetcodecnlearn.Q200;

public class Q276 {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k * k;
        }
        int pre = k;
        int cur = k * k;
        for (int i = 2; i < n; i++) {
            int next = pre * (k - 1) + cur * (k - 1);
            pre = cur;
            cur = next;
        }
        return cur;

    }
}
