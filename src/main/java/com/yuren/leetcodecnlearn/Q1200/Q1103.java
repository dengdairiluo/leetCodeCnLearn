package com.yuren.leetcodecnlearn.Q1200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-25 23:55
 */
public class Q1103 {
    public int[] distributeCandies(int candies, int numPeople) {
        // how many people received complete gifts
        int p = (int) (Math.sqrt(2 * candies + 0.25) - 0.5);
        int remaining = (int) (candies - (p + 1) * p * 0.5);
        int rows = p / numPeople, cols = p % numPeople;

        int[] d = new int[numPeople];
        for (int i = 0; i < numPeople; ++i) {
            // complete rows
            d[i] = (i + 1) * rows + (int) (rows * (rows - 1) * 0.5) * numPeople;
            // cols in the last row
            if (i < cols) {
                d[i] += i + 1 + rows * numPeople;
            }
        }
        // remaining candies
        d[cols] += remaining;
        return d;
    }
}
