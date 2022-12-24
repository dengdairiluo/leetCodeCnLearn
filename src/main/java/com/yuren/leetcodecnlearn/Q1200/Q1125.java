package com.yuren.leetcodecnlearn.Q1200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-03 23:21
 */
public class Q1125 {
    public int[] smallestSufficientTeam(String[] reqSkills, List<List<String>> people) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < reqSkills.length; ++i) {
            map.put(reqSkills[i], i);
        }
        int[] skills = new int[people.size()];
        for (int i = 0; i < skills.length; ++i) {
            for (int j = 0; j < people.get(i).size(); ++j) {
                int idx = map.get(people.get(i).get(j));
                skills[i] |= 1 << idx;
            }
        }
        int[][] dp = new int[1 << reqSkills.length][];
        dp[0] = new int[0];
        int maxSize = 0;
        for (int i = 0; i < skills.length; ++i) {
            if (skills[i] == 0) {
                continue;
            }
            for (int j = 0; j <= maxSize; ++j) {
                if (dp[j] != null) {
                    int combination = j | skills[i];
                    if (dp[combination] == null || dp[j].length + 1 < dp[combination].length) {
                        dp[combination] = Arrays.copyOf(dp[j], dp[j].length + 1);
                        dp[combination][dp[j].length] = i;
                    }
                }
            }
            maxSize |= skills[i];
        }
        return dp[(1 << reqSkills.length) - 1];
    }
}
