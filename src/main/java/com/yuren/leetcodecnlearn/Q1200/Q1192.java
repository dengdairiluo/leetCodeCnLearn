package com.yuren.leetcodecnlearn.Q1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-04 00:47
 */
public class Q1192 {
    List<List<Integer>> critical = new ArrayList<List<Integer>>();
    List<Integer>[] adjacentArr;
    int[] visitTimes;
    int time = -1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        adjacentArr = new List[n];
        for (int i = 0; i < n; i++) {
            adjacentArr[i] = new ArrayList<>();
        }
        for (List<Integer> connection : connections) {
            adjacentArr[connection.get(0)].add(connection.get(1));
            adjacentArr[connection.get(1)].add(connection.get(0));
        }
        visitTimes = new int[n];
        Arrays.fill(visitTimes, -1);
        dfs(0, -1);
        return critical;
    }

    public int dfs(int curr, int prev) {
        if (visitTimes[curr] < 0) {
            time++;
            int currTime = time;
            visitTimes[curr] = currTime;
            List<Integer> adjacent = adjacentArr[curr];
            for (int next : adjacent) {
                if (next == prev) {
                    continue;
                }
                int nextTime = dfs(next, curr);
                visitTimes[curr] = Math.min(visitTimes[curr], nextTime);
                if (nextTime > currTime) {
                    List<Integer> connection = new ArrayList<>();
                    connection.add(curr);
                    connection.add(next);
                    critical.add(connection);
                }
            }
        }
        return visitTimes[curr];
    }
}
