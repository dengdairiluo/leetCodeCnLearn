package com.yuren.leetcodecnlearn.Q1300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-01-31 22:02
 */
public class Q1342 {

    public static int numberOfSteps1(int num) {
        int cnt = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            cnt++;
        }
        return cnt;
    }

    public static int numberOfSteps2(int num) {
        int cnt = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num >>= 1;
            } else {
                num -= 1;
            }
            cnt++;
        }
        return cnt;
    }
}
