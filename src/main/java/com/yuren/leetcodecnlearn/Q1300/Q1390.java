package com.yuren.leetcodecnlearn.Q1300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-20 01:00
 */
public class Q1390 {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += divisors(num);
        }
        return sum;
    }

    private int divisors(int num) {
        int a = -1;
        int b = -1;
        int last = (int) Math.sqrt(num);
        for (int i = 2; i <= last; i++) {
            if (num % i == 0) {
                a = i;
                b = num / i;
                // 有平方根的数，因子数必然是奇数个
                if (a == b) {
                    return 0;
                }
                break;
            }
        }
        if (a == -1) {
            return 0;
        }

        // a必然是素数，因为a是num除1外的最小因子，b是num除自身外最大的因子
        // 综上，只需判断b是否有非a的因子
        // b的非1因子必然大于等于a的
        last = (int) Math.sqrt(b);
        for (int i = a; i <= last; i++) {
            if (b % i == 0 && (b / i) != a) {
                // 有第5个因子，i不可能等于b，所以不用判断i == b
                // b / i 是大于等于 i 的，这里有种特殊情况 i == b/i == a，通过后一项判断排除
                return 0;
            }
        }

        return a + b + 1 + num;
    }
}
