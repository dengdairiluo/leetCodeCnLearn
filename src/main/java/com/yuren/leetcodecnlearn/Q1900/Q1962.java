package com.yuren.leetcodecnlearn.Q1900;

import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-06 23:51
 */
public class Q1962 {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> h = new PriorityQueue<>((a, b) -> (b - a));
        int sum = 0;
        int index[] = new int[10001];
        for (int i : piles) {
            index[i]++;
            sum += i;
        }
        for (int i = 10000; i > 0; i--) {
            if (index[i] > 0) {
                if (k > index[i]) {
                    int m = i / 2 * (index[i]);
                    sum -= m;
                    index[i - i / 2] += index[i];
                    k -= index[i];
                } else {
                    int m = i / 2 * k;
                    sum -= m;
                    break;
                }
            }
        }
        return sum;
    }
}
