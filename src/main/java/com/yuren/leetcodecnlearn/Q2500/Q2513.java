package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-02 下午11:04
 */
public class Q2513 {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        // 计算数1所要求的最大数（队列1大小加上队列1不能要的数）
        int max1 = uniqueCnt1 + (uniqueCnt1 - 1) / (divisor1 - 1);
        // 计算数2所要求的最大数（队列2大小加上队列2不能要的数）
        int max2 = uniqueCnt2 + (uniqueCnt2 - 1) / (divisor2 - 1);
        // 两数的最小公倍数
        long lcm = 1L * divisor2 / gcd(divisor1, divisor2) * divisor1;
        // 计算他们最小公倍数所要求的最大数（两个队列所有数加上两个队列都不能要的数）
        int max3 = (int) (uniqueCnt1 + uniqueCnt2 + (uniqueCnt1 + uniqueCnt2 - 1) / (lcm - 1));
        // 所有最大数中，取最大的。
        return Math.max(max3, Math.max(max1, max2));

    }

    // 计算最大公约数 --辗转相除法
    private int gcd(int divisor1, int divisor2) {
        if (divisor1 == divisor2) {
            return divisor2;
        }
        return divisor1 > divisor2 ? gcd(divisor2, divisor1 - divisor2) : gcd(divisor1, divisor2 - divisor1);
    }
}
