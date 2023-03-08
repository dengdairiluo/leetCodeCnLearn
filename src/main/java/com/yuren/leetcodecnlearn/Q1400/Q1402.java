package com.yuren.leetcodecnlearn.Q1400;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-07-09 23:25
 */
public class Q1402 {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int presum = 0, ans = 0;
        for (int i = satisfaction.length - 1; i >= 0; --i) {
            int si = satisfaction[i];
            if (presum + si > 0) {
                presum += si;
                ans += presum;
            } else {
                break;
            }
        }
        return ans;
    }
}
