package com.yuren.leetcodecnlearn.Q1100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-18 23:43
 */
public class Q1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        int[] seconds = new int[60];
        for (int t : time) {
            seconds[t % 60] += 1;
        }
        count += combination(seconds[30], 2);
        count += combination(seconds[0], 2);
        int i = 1, j = 59;
        while (i < j) {
            count += seconds[i++] * seconds[j--];
        }
        return count;
    }

    // 求组合数
    public int combination(int n, int k) {
        long result = 1;
        for (int i = 1; i <= k; i++) {
            result = result * (n - i + 1) / i;
        }
        return (int) result;
    }

}
