package com.yuren.leetcodecnlearn.Q2200;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-20 23:15
 */
public class Q2248 {
    int[] temp = new int[1001];

    public List<Integer> intersection(int[][] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int[] num : nums) {
            for (int i : num) {
                ++temp[i];
            }
        }
        for (int i = 1; i < 1001; ++i) {
            if (temp[i] == n) {
                ans.add(i);
            }
        }
        return ans;
    }
}
