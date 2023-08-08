package com.yuren.leetcodecnlearn.Q1800;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-08 23:40
 */
public class Q1834 {
    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;
        Task[] extTasks = new Task[n];

        for (int i = 0; i < n; ++i) {
            extTasks[i] = new Task(i, tasks[i][0], tasks[i][1]);
        }

        int[] result = new int[n];
        Arrays.sort(extTasks, Comparator.comparingInt(a -> a.startTime));

        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> a.processingTime != b.processingTime ? a.processingTime - b.processingTime : a.index - b.index);

        int index = 0, taskId = 0, current = 0;

        while (index < n) {
            while (taskId < n && extTasks[taskId].startTime <= current) {
                pq.offer(extTasks[taskId++]);
            }

            if (pq.size() == 0) {
                current = extTasks[taskId].startTime;
                continue;
            }

            Task task = pq.poll();
            result[index++] = task.index;
            current += task.processingTime;
        }

        return result;
    }

    private static class Task {
        int index;
        int startTime;
        int processingTime;

        public Task(int index, int start, int process) {
            this.index = index;
            this.startTime = start;
            this.processingTime = process;
        }
    }

}

