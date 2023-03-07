package com.yuren.leetcodecnlearn.Q1000;

public class Q1025 {

    public boolean divisorGame1(int n) {
        return n % 2 == 0;
    }

    public boolean divisorGame2(int n) {
        boolean[] f = new boolean[n + 5];

        f[1] = false;
        f[2] = true;
        for (int i = 3; i <= n; ++i) {
            for (int j = 1; j < i; ++j) {
                if ((i % j) == 0 && !f[i - j]) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[n];
    }

}
