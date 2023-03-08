package com.yuren.leetcodecnlearn.Q1100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-31 23:35
 */
public class Q1118 {
    public int numberOfDays(int y, int m) {
        int[] year1 = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 闰年
        int[] year2 = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 非闰年
        if ((y % 100 != 0 && y % 4 == 0) || y % 400 == 0) {
            return year1[m - 1];
        }
        return year2[m - 1];
    }
}
