package com.yuren.leetcodecnlearn.Q1100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-30 23:48
 */
public class Q1042 {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] adjacentGardens = new List[n];
        for (int i = 0; i < n; i++) {
            adjacentGardens[i] = new ArrayList<Integer>();
        }
        for (int[] path : paths) {
            int garden0 = path[0] - 1, garden1 = path[1] - 1;
            if (garden0 < garden1) {
                adjacentGardens[garden1].add(garden0);
            } else {
                adjacentGardens[garden0].add(garden1);
            }
        }
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            List<Integer> adjacent = adjacentGardens[i];
            boolean[] used = new boolean[5];
            for (int garden : adjacent) {
                int adjacentType = answer[garden];
                used[adjacentType] = true;
            }
            int type = 1;
            while (used[type]) {
                type++;
            }
            answer[i] = type;
        }
        return answer;
    }
}
