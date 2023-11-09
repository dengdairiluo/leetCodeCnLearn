package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-09 22:42
 */
public class Q2043 {
    private long[] val;

    public Q2043(long[] balance) {
        val = balance;
    }

    boolean check(int account) {
        return 1 <= account && account <= val.length;
    }

    public boolean transfer(int a, int b, long c) {
        if (!check(a) || !check(b)) return false;
        if (val[a - 1] >= c) {
            val[a - 1] -= c;
            val[b - 1] += c;
            return true;
        }
        return false;
    }

    public boolean deposit(int a, long c) {
        if (!check(a)) return false;
        val[a - 1] += c;
        return true;
    }

    public boolean withdraw(int a, long c) {
        if (!check(a)) return false;
        if (val[a - 1] >= c) {
            val[a - 1] -= c;
            return true;
        }
        return false;
    }
}
