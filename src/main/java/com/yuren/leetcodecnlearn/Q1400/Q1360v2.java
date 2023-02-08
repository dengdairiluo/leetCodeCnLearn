package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-08 23:48
 */
public class Q1360v2 {
    public int toDay(String dateStr) {
        String[] temp = dateStr.split("-");
        int year = Integer.parseInt(temp[0]);
        int month = Integer.parseInt(temp[1]);
        int day = Integer.parseInt(temp[2]);

        if (month <= 2) {
            year--;
            month += 10;
        } else {
            month -= 2;
        }
        return 365 * year + year / 4 - year / 100 + year / 400 + 30 * month + (3 * month - 1) / 5 + day;
    }

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(toDay(date1) - toDay(date2));
    }
}
