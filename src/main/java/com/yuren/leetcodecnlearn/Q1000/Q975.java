package com.yuren.leetcodecnlearn.Q1000;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-05 23:59
 */
public class Q975 {
    public int oddEvenJumps(int[] arr) {
        int len = arr.length;
        if (len == 1) {
            return 1;
        }
        int count = 1;
        boolean[] h = new boolean[len];
        boolean[] l = new boolean[len];
        h[len - 1] = l[len - 1] = true;
        Integer[] idxI = new Integer[len];
        Integer[] idxD = new Integer[len];
        for (int i = 0; i < len; i++) {
            idxI[i] = idxD[i] = i;
        }
        Arrays.sort(idxI, (i1, i2) -> {
            if (arr[i1] - arr[i2] != 0) {
                return arr[i1] - arr[i2];
            } else {
                return i1 - i2;
            }
        });
        Arrays.sort(idxD, (i1, i2) -> {
            if (arr[i1] - arr[i2] != 0) {
                return -arr[i1] + arr[i2];
            } else {
                return i1 - i2;
            }
        });
        int[] nextHigher = new int[len];
        int[] nextLower = new int[len];
        Deque<Integer> stackI = new ArrayDeque<>(len);
        Deque<Integer> stackD = new ArrayDeque<>(len);
        stackI.push(idxI[len - 1]);
        stackD.push(idxD[len - 1]);
        int idx;
        for (int i = len - 2; i >= 0; i--) {
            idx = idxI[i];
            while (!stackI.isEmpty() && stackI.peek() < idx) {
                stackI.poll();
            }
            if (stackI.peek() != null) {
                nextHigher[idx] = stackI.peek();
            }
            stackI.push(idx);
            idx = idxD[i];
            while (!stackD.isEmpty() && stackD.peek() < idx) {
                stackD.poll();
            }
            if (stackD.peek() != null) {
                nextLower[idx] = stackD.peek();
            }
            stackD.push(idx);
        }
        for (int i = len - 2; i >= 0; i--) {
            if (nextHigher[i] != 0) {
                h[i] = l[nextHigher[i]];
            }
            if (nextLower[i] != 0) {
                l[i] = h[nextLower[i]];
            }
            if (h[i]) {
                count++;
            }
        }
        return count;
    }
}
