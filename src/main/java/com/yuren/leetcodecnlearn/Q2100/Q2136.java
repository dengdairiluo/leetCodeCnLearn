package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-26 23:18
 */
public class Q2136 {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int max = 0;
        for (int x : growTime)
            if (x > max) max = x;

        int[] count = new int[max + 1];
        for (int i = 0; i < plantTime.length; ++i)
            count[growTime[i]] += plantTime[i];

        int plantDays = 0, result = 0;
        for (int growDays = max; growDays > 0; --growDays) {
            if (count[growDays] == 0) continue;
            plantDays += count[growDays];
            result = Math.max(result, plantDays + growDays);
        }
        return result;
    }
}
