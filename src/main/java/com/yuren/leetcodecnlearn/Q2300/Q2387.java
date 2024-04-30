package com.yuren.leetcodecnlearn.Q2300;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-30 下午11:09
 */
public class Q2387 {
    public int matrixMedian(int[][] grid) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        int m = grid.length, n = grid[0].length;
        for (int[] ints : grid) {
            low = Math.min(low, ints[0]);
            high = Math.max(high, ints[n - 1]);
        }
        high++;
        int target = m * n / 2 + 1;
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            int count = getCount(grid, mid);
            if (count >= target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }

    int getCount(int[][] grid, int v) {
        int result = 0;
        for (int[] g : grid) {
            result += g.length - ArraysX.lowerBound(g, v);
        }
        return result;
    }

    private static class ArraysX {
        public static int lowerBound(int[] a, int key) {
            return lowerBound(a, 0, a.length, key);
        }

        public static int lowerBound(int[] a, int from, int to, int key) {
            if (from == to) return to;
            if (key <= a[from]) return from;
            while (from + 1 < to) {
                int mid = (from + to) / 2;
                if (key <= a[mid]) {
                    to = mid;
                } else {
                    from = mid;
                }
            }
            return to;
        }

        public static <T> int lowerBound(T[] a, T key, Comparator<? super T> cmp) {
            return lowerBound(a, 0, a.length, key, cmp);
        }

        public static <T> int lowerBound(T[] a, int from, int to, T key, Comparator<? super T> cmp) {
            if (from == to) return to;
            if (cmp.compare(key, a[from]) <= 0) return from;
            while (from + 1 < to) {
                int mid = (from + to) / 2;
                if (cmp.compare(key, a[mid]) <= 0) {
                    to = mid;
                } else {
                    from = mid;
                }
            }
            return to;
        }

        public static List<List<Integer>> convertList(int[][] data) {
            List list = new ArrayList();
            for (int[] d : data) {
                List ilist = new ArrayList();
                for (int n : d) {
                    ilist.add(n);
                }
                list.add(ilist);
            }
            return list;
        }

        public static List<List<String>> convertList(String[][] data) {
            List list = new ArrayList();
            for (String[] d : data) {
                List ilist = new ArrayList();
                for (String n : d) {
                    ilist.add(n);
                }
                list.add(ilist);
            }
            return list;
        }
    }

}
