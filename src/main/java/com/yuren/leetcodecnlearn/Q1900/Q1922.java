package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-12 23:51
 */
public class Q1922 {
    public int countGoodNumbers(long n) {
        int N = (int) Math.pow(10, 9) + 7;
        //如果是奇数,还得乘个5
        int cheng = 1;
        if (n % 2 == 1) {
            cheng = 5;
            //n变为偶数
            n -= 1;
        }
        //n中有多少个偶数
        long o = n / 2;
        // 4*5 的 偶数 次方
        long a = myPow(20, o, N);
        long ans = a * cheng;
        return (int) (ans % N);
    }

    //快速幂 (记得要取余N,不只是结果取余,每次乘机也要取余)
    public long myPow(long x, long n, int N) {
        if (n == 0) {
            return 1;
        }
        long m = n;
        long sum = 1;
        while (m != 0) {
            if ((m & 1) == 1) {
                sum *= x;
                sum %= N;
            }
            x *= x;
            x %= N;
            m >>= 1;
        }
        return sum;
    }

}
