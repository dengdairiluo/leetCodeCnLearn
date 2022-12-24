package com.yuren.leetcodecnlearn.Q1200;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-27 21:20
 */
public class Q1177 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[] sum = new int[s.length() + 1];
        for (int i = 1; i < sum.length; i++) {
            int index = s.charAt(i - 1) - 'a';
            sum[i] = sum[i - 1] ^ (1 << index);
        }

        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            ans.add(Integer.bitCount(sum[queries[i][1] + 1] ^ sum[queries[i][0]]) <= (1 + (queries[i][2] << 1)));
        }
        return ans;
    }
}
