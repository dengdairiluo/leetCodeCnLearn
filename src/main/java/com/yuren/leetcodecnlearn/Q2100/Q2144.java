package com.yuren.leetcodecnlearn.Q2100;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-31 19:16
 */
public class Q2144 {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int index = cost.length - 1, ans = 0;
        while (index >= 0) {
            ans += cost[index];
            if (index - 1 >= 0)
                ans += cost[index - 1];

            index -= 3;
        }

        return ans;
    }
}
