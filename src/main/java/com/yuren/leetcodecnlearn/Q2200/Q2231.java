package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-11 22:16
 */
public class Q2231 {
    public int largestInteger(int num) {
        int[] nums = new int[10];
        int[] hash = new int[10];
        int rank = 0;
        while (num > 0) {
            nums[rank] = num % 10;
            hash[nums[rank++]]++;
            num /= 10;
        }
        int res = 0;
        int num1 = 9, num2 = 8;
        for (int i = rank - 1; i >= 0; i--) {
            if (nums[i] % 2 == 0) {
                for (int j = num2; j >= 0; j -= 2) {
                    if (hash[j] > 0) {
                        res = res * 10 + j;
                        if (--hash[j] == 0) {
                            num2 -= 2;
                        }
                        break;
                    }
                }
            } else {
                for (int j = num1; j >= 1; j -= 2) {
                    if (hash[j] > 0) {
                        res = res * 10 + j;
                        if (--hash[j] == 0) {
                            num1 -= 2;
                        }
                        break;
                    }
                }
            }
        }
        return res;
    }
}
