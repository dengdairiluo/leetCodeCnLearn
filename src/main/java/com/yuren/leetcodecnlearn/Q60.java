package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-08-29 21:54
 */
public class Q60 {

    /**
     * 阶乘
     */
    private static final int[] FAC = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    public String getPermutation(int n, int k) {

        int count = 0;
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        k--;
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        for (int i = n; i >= 1; i--) {
            int r = k / FAC[i - 1];
            int y = k % FAC[i - 1];
            k = y;

            sb.append(list.get(r));
            list.remove(r);
        }
        return sb.toString();
    }
}
