package com.yuren.leetcodecnlearn.Q2400;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-14 上午12:13
 */
public class Q2410 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int m = players.length, n = trainers.length;
        int count = 0;
        for (int i = 0, j = 0; i < m && j < n; i++, j++) {
            while (j < n && players[i] > trainers[j]) {
                j++;
            }
            if (j < n) {
                count++;
            }
        }
        return count;
    }
}
