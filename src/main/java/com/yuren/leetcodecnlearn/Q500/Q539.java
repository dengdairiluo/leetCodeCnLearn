package com.yuren.leetcodecnlearn.Q500;

import java.util.Collections;
import java.util.List;

public class Q539 {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if (n > 1440) {
            return 0;
        }
        Collections.sort(timePoints);
        int ans = Integer.MAX_VALUE;
        int t0Minutes = getMinutes(timePoints.get(0));
        int preMinutes = t0Minutes;
        for (int i = 1; i < n; ++i) {
            int minutes = getMinutes(timePoints.get(i));
            // 相邻时间的时间差
            ans = Math.min(ans, minutes - preMinutes);
            preMinutes = minutes;
        }
        // 首尾时间的时间差
        ans = Math.min(ans, t0Minutes + 1440 - preMinutes);
        return ans;
    }

    public int getMinutes(String t) {
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
    }
}
