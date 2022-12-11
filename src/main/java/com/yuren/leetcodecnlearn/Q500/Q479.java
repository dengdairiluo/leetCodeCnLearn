package com.yuren.leetcodecnlearn.Q500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-01-27 23:25
 */
public class Q479 {
    public int largestPalindrome(int n) {
        // n位最大数
        int largest = (int) Math.pow(10, n) - 1;
        // 平方最大值
        long max = (long) Math.pow(largest, 2);
        for (int i = largest - 1; i > 0; i--) {
            // i同i镜像组成的回文数
            long num = this.palindrome(i);
            for (long ans = largest; num <= max && ans * ans >= num; ans--) {
                if (num % ans == 0) {
                    return (int) (num % 1337);
                }
            }
        }
        return 9;
    }

    private long palindrome(int num) {
        long mirror = 0;
        long ans = num;
        while (num > 0) {
            mirror = mirror * 10 + num % 10;
            ans *= 10;
            num /= 10;
        }
        return ans + mirror;
    }
}
