package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-11 22:22
 */
public class Q2169 {
    public int countOperations(int num1, int num2) {
        int ret = 0;

        while (num1 != 0 && num2 != 0) {
            int tmp = Math.max(num1, num2) % Math.min(num1, num2);
            ret = ret + Math.max(num1, num2) / Math.min(num1, num2);
            num1 = Math.min(num1, num2);
            num2 = tmp;
        }
        return ret;

    }
}
