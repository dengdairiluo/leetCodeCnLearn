package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-02-10 22:11
 */
public class Q1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int cnt = 0;
        for (int i = 0; i < startTime.length; i++) {
           cnt += startTime[i] <= queryTime && queryTime <= endTime[i] ? 1 : 0;
        }
        return cnt;
    }
}
