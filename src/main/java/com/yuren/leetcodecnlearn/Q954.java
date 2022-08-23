package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-24 00:03
 */
public class Q954 {
    private static final int N = 100010, M = N * 2;
    private static final int[] CNTS = new int[M * 2];

    public boolean canReorderDoubled(int[] arr) {
        Arrays.fill(CNTS, 0);
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (++CNTS[i + M] == 1) {
                list.add(i);
            }
        }
        list.sort(Comparator.comparingInt(Math::abs));
        for (int i : list) {
            if (CNTS[i * 2 + M] < CNTS[i + M]) {
                return false;
            }
            CNTS[i * 2 + M] -= CNTS[i + M];
        }
        return true;
    }
}
