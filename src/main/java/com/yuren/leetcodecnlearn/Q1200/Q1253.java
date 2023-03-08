package com.yuren.leetcodecnlearn.Q1200;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-05 00:14
 */
public class Q1253 {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int sum = 0, len = colsum.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int k : colsum) {
            sum += k;
        }
        // 如果行列元素之和不相等
        if (upper + lower != sum) {
            return list;
        }
        List<Integer> upl = new ArrayList<>();
        List<Integer> lol = new ArrayList<>();
        for (int j : colsum) {
            if (j == 2) {
                upl.add(1);
                lol.add(1);
                upper--;
                lower--;
            } else if (j == 0) {
                upl.add(0);
                lol.add(0);
            } else {
                if (upper > lower) {
                    upl.add(1);
                    lol.add(0);
                    upper--;
                } else {
                    lol.add(1);
                    upl.add(0);
                    lower--;
                }
            }
            // 如果行元素不够分配
            if (upper < 0 || lower < 0) {
                return list;
            }
        }
        list.add(upl);
        list.add(lol);
        return list;
    }
}
