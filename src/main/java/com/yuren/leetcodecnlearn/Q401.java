package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-12-25 20:42
 */
public class Q401 {
    private static final int[] HOURS = new int[]{1, 2, 4, 8, 0, 0, 0, 0, 0, 0};
    private static final int[] MINUTES = new int[]{0, 0, 0, 0, 1, 2, 4, 8, 16, 32};
    private final List<String> res = new ArrayList<>();

    public List<String> readBinaryWatch(int num) {
        backtrack(num, 0, 0, 0);
        return res;
    }

    public void backtrack(int num, int index, int hour, int minute) {
        if (hour > 11 || minute > 59)
            return;
        if (num == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(hour).append(':');
            if (minute < 10) {
                sb.append('0');
            }
            sb.append(minute);
            res.add(sb.toString());
            return;
        }
        for (int i = index; i < 10; i++) {
            backtrack(num - 1, i + 1, hour + HOURS[i], minute + MINUTES[i]);
        }
    }
}
