package com.yuren.leetcodecnlearn.Q600;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-05 02:19
 */
public class Q630 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        // 优先队列中所有课程的总时间
        int total = 0;

        for (int[] course : courses) {
            int ti = course[0], di = course[1];
            if (total + ti <= di) {
                total += ti;
                q.offer(ti);
            } else if (!q.isEmpty() && q.peek() > ti) {
                total -= q.poll() - ti;
                q.offer(ti);
            }
        }

        return q.size();
    }
}
