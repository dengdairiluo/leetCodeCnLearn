package com.yuren.leetcodecnlearn.Q2100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-04 23:46
 */
public class Q2155 {
    public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        int max = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cur--;
            } else {
                cur++;
                if (cur > max) {
                    max = cur;
                    result.clear();
                    result.add(i + 1);
                } else if (cur == max) {
                    result.add(i + 1);
                }

            }
        }
        return result;
    }
}
