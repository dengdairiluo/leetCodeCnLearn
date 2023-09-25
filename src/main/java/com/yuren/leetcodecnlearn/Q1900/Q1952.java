package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-25 22:21
 */
public class Q1952 {
    // *) 快速判定素数(简单暴力)
    boolean isPrime(int v) {
        for (int i = 2; i < v; i++) {
            if (v % i == 0) return false;
        }
        return true;
    }

    public boolean isThree(int n) {
        if (n == 1) return false;

        int t = (int) Math.sqrt(n);
        return t * t == n && isPrime(t);
    }

}
