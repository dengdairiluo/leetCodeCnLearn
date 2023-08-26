package com.yuren.leetcodecnlearn.Q1800;

import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-26 21:08
 */
public class Q1882 {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        PriorityQueue<Long> times = new PriorityQueue<>();
        int length = servers.length;
        int l = tasks.length;
        int[] arr = new int[l];
        for (int i = 0; i < length; i++) {
            queue.add(((long) servers[i] << 32) + i);
        }
        long time = 0;
        for (int i = 0; i < l; i++) {
            int task = tasks[i];
            time = Math.max(time, i);
            while (!times.isEmpty()) {
                long p = times.peek();
                if ((int) (p >> 32) <= time) {
                    times.poll();
                    int index = (int) p;
                    queue.add(((long) servers[index] << 32) + index);
                } else {
                    break;
                }
            }
            if (queue.isEmpty()) {
                long p = times.poll();
                time = (int) (p >> 32);
                int index = (int) p;
                queue.add(((long) servers[index] << 32) + index);
                while (!times.isEmpty()) {
                    p = times.peek();
                    int t = (int) (p >> 32);
                    if (t == time) {
                        index = (int) p;
                        queue.add(((long) servers[index] << 32) + index);
                        times.poll();
                    } else {
                        break;
                    }
                }
            }
            int index = queue.poll().intValue();
            times.add(((time + task) << 32) + index);
            arr[i] = index;
        }
        return arr;
    }
}
