package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-07-30 22:20
 */
public class Q1940 {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        int len = arrays.length;
        int[] t = new int[101];
        for (int[] a : arrays) {
            for (int x : a) {
                t[x]++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            if (t[i] == len) {
                list.add(i);
            }
        }
        return list;


    }
}
