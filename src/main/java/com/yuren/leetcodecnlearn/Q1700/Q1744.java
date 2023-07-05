package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-05 23:36
 */
public class Q1744 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        long[] sum = new long[candiesCount.length + 1];

        //sum表示到要能吃到第i类的糖果必须要吃掉前面多少个糖果
        for (int i = 0; i < candiesCount.length; i++) {
            sum[i + 1] = sum[i] + candiesCount[i];
        }


        for (int i = 0; i < queries.length; i++) {
            //表示在favoriteDay之前能吃掉的最多的糖果
            long maxEat = (long) queries[i][1] * queries[i][2];
            //表示在favoriteDay之前能吃掉的最少的糖果
            int minEat = queries[i][1];

            ans[i] = (maxEat + queries[i][2] > sum[queries[i][0]]) && (minEat < sum[queries[i][0] + 1]);
        }

        return ans;

    }
}
