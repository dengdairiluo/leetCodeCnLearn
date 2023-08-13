package com.yuren.leetcodecnlearn.Q1800;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-13 22:46
 */
public class Q1847 {

    public int[] closestRoom(int[][] rooms, int[][] queries) {
        Arrays.sort(rooms, (o1, o2) -> o2[1] - o1[1]);
        int m = rooms.length;
        int n = queries.length;
        Query[] q = new Query[n];
        for (int i = 0; i < n; i += 1) {
            q[i] = new Query(queries[i][0], queries[i][1], i);
        }
        Arrays.sort(q, (o1, o2) -> o2.size - o1.size);
        TreeSet<Integer> set = new TreeSet<>();
        int[] answer = new int[n];
        int inf = (int) 1e9;
        for (int i = 0, j = 0; i < n; i += 1) {
            while (j < m && rooms[j][1] >= q[i].size) set.add(rooms[j++][0]);
            Integer iter = set.ceiling(q[i].prefer);
            int cur = -1, diff = inf;
            if (iter != null) {
                if (diff > iter - q[i].prefer) {
                    diff = iter - q[i].prefer;
                    cur = iter;
                }
            }
            iter = set.floor(q[i].prefer);
            if (iter != null) {
                if (diff >= q[i].prefer - iter) {
                    diff = q[i].prefer - iter;
                    cur = iter;
                }
            }
            answer[q[i].index] = cur;
        }
        return answer;
    }

    private static class Query {
        public int prefer;
        public int size;
        public int index;

        Query(int prefer, int size, int index) {
            this.prefer = prefer;
            this.size = size;
            this.index = index;
        }
    }
}
