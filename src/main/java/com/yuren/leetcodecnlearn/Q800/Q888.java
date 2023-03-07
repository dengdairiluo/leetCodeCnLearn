package com.yuren.leetcodecnlearn.Q800;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-27 21:05
 */
public class Q888 {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int aliceTotal = 0, bobTotal = 0;
        for (int aliceSize : aliceSizes) {
            aliceTotal += aliceSize;
        }
        Set<Integer> bobSet = new HashSet<>(bobSizes.length);
        for (int bobSize : bobSizes) {
            bobTotal += bobSize;
            bobSet.add(bobSize);
        }
        if (aliceTotal == bobTotal) {
            return new int[]{};
        }
        int pause = (aliceTotal + bobTotal) / 2 - aliceTotal;

        for (int aliceSize : aliceSizes) {
            if (bobSet.contains(aliceSize + pause)) {
                return new int[]{aliceSize, aliceSize + pause};
            }
        }
        return new int[]{};
    }
}
