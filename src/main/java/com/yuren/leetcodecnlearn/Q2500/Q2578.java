package com.yuren.leetcodecnlearn.Q2500;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-04 下午11:46
 */
public class Q2578 {
    public int splitNum(int num) {
        char[] stNum = Integer.toString(num).toCharArray();
        Arrays.sort(stNum);
        int num1 = 0, num2 = 0;
        for (int i = 0; i < stNum.length; ++i) {
            if (i % 2 == 0) {
                num1 = num1 * 10 + (stNum[i] - '0');
            } else {
                num2 = num2 * 10 + (stNum[i] - '0');
            }
        }
        return num1 + num2;
    }
}
