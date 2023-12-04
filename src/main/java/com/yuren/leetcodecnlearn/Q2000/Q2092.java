package com.yuren.leetcodecnlearn.Q2000;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-04 23:22
 */
public class Q2092 {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        int[] knowTimes = new int[n];
        Arrays.fill(knowTimes, -1);
        knowTimes[firstPerson] = 0;
        knowTimes[0] = 0;
        List<int[]>[] talkTos = new List[n];
        for (int i = 0; i < n; i++) {
            talkTos[i] = new ArrayList<>();
        }
        for (int[] met : meetings) {
            talkTos[met[0]].add(new int[]{met[1], met[2]});
            talkTos[met[1]].add(new int[]{met[0], met[2]});
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        queue.add(firstPerson);
        while (!queue.isEmpty()) {
            int curPer = queue.poll();
            for (int[] next : talkTos[curPer]) {
                if (knowTimes[next[0]] == -1 && knowTimes[curPer] <= next[1]) {
                    knowTimes[next[0]] = next[1];
                    queue.offer(next[0]);
                }
                if (knowTimes[next[0]] > next[1] && knowTimes[curPer] <= next[1]) {
                    knowTimes[next[0]] = next[1];
                    queue.offer(next[0]);
                }
            }
        }

        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (knowTimes[i] != -1) {
                resList.add(i);
            }
        }

        return resList;
    }
}
