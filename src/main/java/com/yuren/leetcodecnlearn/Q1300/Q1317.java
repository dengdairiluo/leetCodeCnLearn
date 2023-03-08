package com.yuren.leetcodecnlearn.Q1300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-22 23:25
 */
public class Q1317 {
    public int[] getNoZeroIntegers(int n) {
        int num1 = 1, num2 = n - 1;
        boolean flag = false;
        while (num1 <= num2 && !flag) {
            if (noZero(num1) && noZero(num2)) {
                flag = true;
            } else {
                num1++;
                num2--;
            }
        }
        return new int[]{num1, num2};
    }

    public boolean noZero(int num) {
        while (num > 0) {
            int remainder = num % 10;
            if (remainder == 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}
