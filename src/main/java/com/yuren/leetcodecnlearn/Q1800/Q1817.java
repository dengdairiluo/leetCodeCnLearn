package com.yuren.leetcodecnlearn.Q1800;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-06 21:23
 */
public class Q1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans = new int[k];
        Arrays.sort(logs, (l1, l2) -> l1[0] == l2[0] ? l1[1] - l2[1] : l1[0] - l2[0]);
        int id = logs[0][0], time = 1;
        for (int i = 1; i < logs.length; i++) {
            int[] log = logs[i];
            if (log[0] == id && log[1] != logs[i - 1][1]) time++;
            else if (log[0] != id) {
                ans[time - 1]++;
                id = log[0];
                time = 1;
            }
        }
        ans[time - 1]++;
        return ans;
    }
}
