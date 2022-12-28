package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-06-13 23:43
 */
public class Q1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int count = 0;
        int[] ans = new int[1001];
        for (int[] is : boxTypes) {
            ans[is[1]] += is[0];
        }
        for (int i = ans.length - 1; i > 0; i--) {
            if (ans[i] != 0) {
                if (truckSize > ans[i]) {
                    count += ans[i] * i;
                    truckSize -= ans[i];
                } else {
                    return count + truckSize * i;
                }
            }
        }
        return count;
    }
}
