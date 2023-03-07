package com.yuren.leetcodecnlearn.Q1000;

import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-07 23:47
 */
public class Q1057 {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        PriorityQueue<Manhattan> pQueue = new PriorityQueue<>();
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int manhattanDis = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                pQueue.offer(new Manhattan(i, j, manhattanDis));
            }
        }
        int[] ans = new int[workers.length];
        boolean[] visit = new boolean[workers.length];
        boolean[] bikeVisit = new boolean[bikes.length];
        int workerCount = 0;
        while (!pQueue.isEmpty() && workerCount <= workers.length) {
            Manhattan temp = pQueue.poll();
            if (!visit[temp.workerNum] && !bikeVisit[temp.bikeNum]) {
                ans[temp.workerNum] = temp.bikeNum;
                visit[temp.workerNum] = true;
                bikeVisit[temp.bikeNum] = true;
                workerCount++;
            }
        }
        return ans;
    }

    private static class Manhattan implements Comparable<Manhattan> {
        int workerNum;
        int bikeNum;
        int manhatDistance;

        Manhattan(int workerNum, int bikeNum, int manhatDistance) {
            this.workerNum = workerNum;
            this.bikeNum = bikeNum;
            this.manhatDistance = manhatDistance;
        }

        @Override
        public int compareTo(Manhattan o) {
            if (this.manhatDistance == o.manhatDistance) {
                if (this.workerNum == o.workerNum) {
                    return this.bikeNum - o.bikeNum;
                } else {
                    return this.workerNum - o.workerNum;
                }
            } else {
                return this.manhatDistance - o.manhatDistance;
            }
        }
    }
}
