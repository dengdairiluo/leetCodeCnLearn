package com.yuren.leetcodecnlearn.Q700;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-23 20:33
 */
public class Q672 {
    public int flipLights(int n, int m) {
        Set<Integer> seen = new HashSet();
        n = Math.min(n, 6);
        int shift = Math.max(0, 6 - n);
        for (int cand = 0; cand < 16; ++cand) {
            int bCount = Integer.bitCount(cand);
            if (bCount % 2 == m % 2 && bCount <= m) {
                int lights = 0;
                if (((cand >> 0) & 1) > 0) lights ^= 0b111111 >> shift;
                if (((cand >> 1) & 1) > 0) lights ^= 0b010101 >> shift;
                if (((cand >> 2) & 1) > 0) lights ^= 0b101010 >> shift;
                if (((cand >> 3) & 1) > 0) lights ^= 0b100100 >> shift;
                seen.add(lights);
            }
        }
        return seen.size();
    }
}
