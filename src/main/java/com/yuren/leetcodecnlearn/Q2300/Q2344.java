package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-08 下午11:51
 */
public class Q2344 {
    public int minOperations(int[] nums, int[] numsDivide) {
        int divisor = 0;
        for (int num : numsDivide) {
            divisor = gcd(divisor, num);
            if (divisor == 1) {
                break;
            }
        }
        int minNum = Integer.MAX_VALUE;
        for (int num : nums) {
            if (divisor % num == 0) {
                minNum = Math.min(minNum, num);
            }
        }
        if (minNum == Integer.MAX_VALUE) {
            return -1;
        }
        int operations = 0;
        for (int num : nums) {
            if (num < minNum) {
                operations++;
            }
        }
        return operations;
    }

    public int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }
}
