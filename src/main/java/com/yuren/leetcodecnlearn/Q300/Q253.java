package com.yuren.leetcodecnlearn.Q300;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-10-30 20:40
 */
public class Q253 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        q.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (q.peek() <= intervals[i][0]) {
                q.poll();
            }
            q.add(intervals[i][1]);
        }
        return q.size();
    }
}
