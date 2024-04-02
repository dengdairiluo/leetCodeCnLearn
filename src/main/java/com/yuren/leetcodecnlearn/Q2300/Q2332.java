package com.yuren.leetcodecnlearn.Q2300;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-02 23:16
 */
public class Q2332 {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int j = 0, c = 0;
        for (int t : buses)
            for (c = capacity; c > 0 && j < passengers.length && passengers[j] <= t; --c)
                ++j;
        --j;
        // 在发车时到达公交站 or 上一个上车的乘客
        int ans = c > 0 ? buses[buses.length - 1] : passengers[j];
        // 往前找没人到达的时刻
        while (j >= 0 && passengers[j--] == ans) --ans;
        return ans;
    }
}
