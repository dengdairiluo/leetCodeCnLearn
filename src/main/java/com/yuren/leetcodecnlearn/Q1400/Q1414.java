package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-27 22:49
 */
public class Q1414 {
    private static final int[] NUMS = {1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181,
            6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578,
            5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437,
            701408733};

    private int findMinFibonacciNumbers(int k) {
        int ans = 0;
        for (int i = NUMS.length - 1; k > 0; --i) {
            int num = NUMS[i];
            ans += k / num;
            k %= num;
        }
        return ans;
    }
}
