package com.yuren.leetcodecnlearn.Q1300;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-12 23:38
 */
public class Q1366 {

    public String rankTeams(String[] votes) {
        int n = votes.length;
        int len = votes[0].length();
        int[][] map = new int[26][len + 1];
        for (int i = 0; i < 26; i++) {
            map[i][0] = i;
        }
        for (String vote : votes) {
            int idx = 1;
            for (char ch : vote.toCharArray()) {
                map[ch - 'A'][idx] += 1;
                idx++;
            }

        }
        Arrays.sort(map, (o1, o2) -> {
            int n1 = o1.length;
            for (int i = 1; i < n1; i++) {
                if (o2[i] > o1[i]) {
                    return 1;
                } else if (o2[i] < o1[i]) {
                    return -1;
                }
            }
            return o1[0] - o2[0];
        });
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            res.append((char) (map[i][0] + 'A'));
        }

        return res.toString();
    }
}
