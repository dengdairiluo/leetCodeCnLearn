package com.yuren.leetcodecnlearn.Q1900;

import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-20 23:47
 */
public class Q1942 {
    public int smallestChair(int[][] times, int targetFriend) {
        int[] tar = times[targetFriend];
        int tarArrivalTime = tar[0];
        PriorityQueue<int[]> each = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b.length - a.length;
            }
        });
        for (int[] time : times) {
            if (time[0] <= tarArrivalTime) {
                each.add(time);
            }
        }
        PriorityQueue<Integer> chairs = new PriorityQueue<>();
        int chairIdx = 0;
        while (true) {
            int[] now = each.poll();
            //take
            if (now.length == 2) {
                if (tarArrivalTime == now[0]) {
                    return chairs.isEmpty() ? chairIdx : chairs.poll();
                }
                if (chairs.isEmpty()) {
                    each.add(new int[]{now[1], chairIdx, -1});
                    chairIdx++;
                } else {
                    Integer chair = chairs.poll();
                    each.add(new int[]{now[1], chair, -1});
                }
                //return
            } else {
                chairs.add(now[1]);
            }
        }
    }
}
