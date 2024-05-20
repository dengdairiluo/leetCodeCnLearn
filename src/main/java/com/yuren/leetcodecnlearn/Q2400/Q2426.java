package com.yuren.leetcodecnlearn.Q2400;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-20 下午11:56
 */
public class Q2426 {
    public long numberOfPairs(int[] a, int[] nums2, int diff) {
        int n = a.length;
        for (int i = 0; i < n; ++i)
            a[i] -= nums2[i];
        int[] b = Arrays.stream(a).distinct().sorted().toArray(); // 配合下面的二分，离散化

        long ans = 0L;
        BIT t = new BIT(b.length + 1);
        for (int x : a) {
            ans += t.query(lowerBound(b, x + diff + 1));
            t.add(lowerBound(b, x) + 1);
        }
        return ans;
    }

    private int lowerBound(int[] a, int x) {
        int left = 0, right = a.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] < x) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    private static class BIT {
        private final int[] tree;

        public BIT(int n) {
            tree = new int[n];
        }

        public void add(int x) {
            while (x < tree.length) {
                ++tree[x];
                x += x & -x;
            }
        }

        public int query(int x) {
            int res = 0;
            while (x > 0) {
                res += tree[x];
                x &= x - 1;
            }
            return res;
        }
    }

}
