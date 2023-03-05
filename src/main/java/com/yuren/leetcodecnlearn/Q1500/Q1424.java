package com.yuren.leetcodecnlearn.Q1500;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-05 22:19
 */
public class Q1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int m = nums.size();
        int n = 0;
        for (List<Integer> l : nums) {
            n = Math.max(n, l.size());
        }
        Deque<Integer>[] qa = new ArrayDeque[m + n - 1];
        Arrays.setAll(qa, x -> new ArrayDeque<>());
        int p = 0;
        int count = 0;
        for (List<Integer> l : nums) {
            int size = l.size();
            count += size;
            for (int i = 0; i < size; i++) {
                qa[i + p].addFirst(l.get(i));
            }
            p++;
        }
        int[] ans = new int[count];
        int i = 0;
        for (Deque<Integer> q : qa) {
            while (!q.isEmpty()) {
                ans[i++] = q.pollFirst();
            }
        }

        return ans;
    }
}
