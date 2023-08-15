package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-15 23:34
 */
public class Q1851 {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] iLen = new int[intervals.length];
        for (int i = 0; i < iLen.length; i++) {
            iLen[i] = intervals[i][1] - intervals[i][0] + 1;
        }

        int[] iSort = new int[intervals.length];
        for (int i = 0; i < iSort.length; i++) iSort[i] = i;
        quicksort(iSort, intervals, 0, iSort.length - 1);

        int[] ansSort = new int[queries.length];
        for (int i = 0; i < ansSort.length; i++) ansSort[i] = i;
        quicksort(ansSort, queries, 0, ansSort.length - 1);

        int addTail = 0;
        int[] ans = new int[queries.length];
        int[] queue = new int[intervals.length + 1];

        for (int i = 0; i < ansSort.length; i++) {
            int querie = queries[ansSort[i]];
            while (addTail < intervals.length && intervals[iSort[addTail]][0] <= querie) {
                if (intervals[iSort[addTail]][1] >= querie) {
                    heapOffer(queue, iLen, iSort[addTail]);
                }
                addTail++;
            }
            while (queue[0] > 0 && intervals[queue[1]][1] < querie) {
                heapPoll(queue, iLen);
            }
            ans[ansSort[i]] = queue[0] > 0 ? iLen[queue[1]] : -1;
        }

        return ans;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static void heapOffer(int[] list, int[] item, int val) {
        list[++list[0]] = val;
        heapUp(list, item, list[0]);
    }

    static void heapUp(int[] list, int[] item, int cIndex) {
        int pIndex = cIndex >> 1;
        while (cIndex > 1 && item[list[cIndex]] < item[list[pIndex]]) {
            swap(list, cIndex, pIndex);
            cIndex >>= 1;
            pIndex = cIndex >> 1;
        }
    }

    static int heapPoll(int[] list, int[] item) {
        final int res = list[1];
        swap(list, 1, list[0]--);
        heapDown(list, item, 1);
        return res;
    }

    static void heapDown(int[] list, int[] item, int cIndex) {
        final int end = list[0];
        int lIndex, rIndex, tIndex;
        while (cIndex < end) {
            lIndex = cIndex << 1;
            rIndex = cIndex << 1 | 1;
            if (lIndex > end) break;
            if (rIndex > end || item[list[lIndex]] < item[list[rIndex]]) tIndex = lIndex;
            else tIndex = rIndex;
            if (item[list[cIndex]] > item[list[tIndex]]) {
                swap(list, cIndex, tIndex);
                cIndex = tIndex;
            } else break;
        }
    }

    static void quicksort(int[] list, int[][] item, int left, int right) {
        if (left >= right) return;
        int head = left - 1, tail = right + 1;
        int target = item[list[head + tail >> 1]][0];
        while (head < tail) {
            do head++; while (item[list[head]][0] < target);
            do tail--; while (item[list[tail]][0] > target);
            if (head < tail) swap(list, head, tail);
        }
        quicksort(list, item, left, tail);
        quicksort(list, item, tail + 1, right);
    }

    static void quicksort(int[] list, int[] item, int left, int right) {
        if (left >= right) return;
        int head = left - 1, tail = right + 1;
        int target = item[list[head + tail >> 1]];
        while (head < tail) {
            do head++; while (item[list[head]] < target);
            do tail--; while (item[list[tail]] > target);
            if (head < tail) swap(list, head, tail);
        }
        quicksort(list, item, left, tail);
        quicksort(list, item, tail + 1, right);
    }
}
