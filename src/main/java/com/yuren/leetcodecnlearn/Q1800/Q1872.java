package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-22 23:24
 */
public class Q1872 {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int res = sum;

        for (int i = n - 1; i >= 2; i--) {
            sum -= stones[i];
            res = Math.max(res, sum - res);
        }
        return res;
    }
}
