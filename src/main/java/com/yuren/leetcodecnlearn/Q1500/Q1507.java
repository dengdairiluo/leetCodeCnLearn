package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-06 00:29
 */
public class Q1507 {
    private static final String[] MONTH = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    private String reformatDate(String date) {
        int nextIndex = 0;

        int dayNum = 0;
        if (date.charAt(1) <= 57) {
            dayNum = convertNum(date, nextIndex, 2);
            nextIndex = 5;
        } else {
            dayNum = convertNum(date, nextIndex, 1);
            nextIndex = 4;
        }

        int month = search(date, nextIndex);

        nextIndex += 4;
        int year = convertNum(date, nextIndex, 4);
        StringBuilder sb = new StringBuilder(10);
        sb.append(year).append("-");
        if (month < 10) {
            sb.append("0");
        }
        sb.append(month).append("-");
        if (dayNum < 10) {
            sb.append("0");
        }
        sb.append(dayNum);
        return sb.toString();
    }

    private int convertNum(String date, int start, int len) {
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += (int) ((date.charAt(start + i) - 48) * Math.pow(10, len - i - 1));
        }
        return sum;
    }

    /**
     * 对月份做匹配
     *
     * @param date
     * @param start
     * @return
     */
    private int search(String date, int start) {
        for (int i = 0; i < MONTH.length; i++) {
            String m = MONTH[i];
            boolean eq = true;
            for (int j = 0; j < 3; j++) {
                if (m.charAt(j) != date.charAt(start + j)) {
                    eq = false;
                    break;
                }
            }
            if (eq) {
                return i + 1;
            }
        }
        return -1;
    }
}
