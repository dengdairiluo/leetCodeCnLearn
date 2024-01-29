package com.yuren.leetcodecnlearn.Q2200;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-29 23:27
 */
public class Q2204 {
    public int[] distanceToCycle(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList();
        int[] indeg = new int[n];
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            graph[a].add(b);
            graph[b].add(a);
            indeg[a]++;
            indeg[b]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 1) {
                queue.add(i);
                indeg[i]--;
            }
        }
        int[] res = new int[n];
        if (queue.isEmpty()) {
            return res;
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph[curr]) {
                indeg[next]--;
                if (indeg[next] == 1) queue.add(next);
            }
        }
        Arrays.fill(res, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 2) {
                queue.add(i);
                res[i] = 0;
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph[curr]) {
                if (res[next] == Integer.MAX_VALUE) queue.add(next);
                res[next] = Math.min(res[next], res[curr] + 1);
            }
        }
        return res;
    }
}
