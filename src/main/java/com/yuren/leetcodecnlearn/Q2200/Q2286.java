package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-10 23:05
 */
public class Q2286 {
    private int n, m;
    private int[] min;
    private long[] sum;

    public Q2286(int n, int m) {
        this.n = n;
        this.m = m;
        int len = 2 << Integer.toBinaryString(n).length();
        min = new int[len];
        sum = new long[len];
    }

    public int[] gather(int k, int maxRow) {
        int i = index(1, 1, n, maxRow + 1, m - k);
        if (i == 0) {
            return new int[0]; // 不存在
        }
        int seats = (int) querySum(1, 1, n, i, i);
        add(1, 1, n, i, k); // 占据 k 个座位
        return new int[]{i - 1, seats};
    }

    public boolean scatter(int k, int maxRow) {
        if ((long) (maxRow + 1) * m - querySum(1, 1, n, 1, maxRow + 1) < k) return false; // 剩余座位不足 k 个
        // 从第一个没有坐满的排开始占座
        for (int i = index(1, 1, n, maxRow + 1, m - 1); ; ++i) {
            int left_seats = m - (int) querySum(1, 1, n, i, i);
            if (k <= left_seats) { // 剩余人数不够坐后面的排
                add(1, 1, n, i, k);
                return true;
            }
            k -= left_seats;
            add(1, 1, n, i, left_seats);
        }
    }

    // 将 idx 上的元素值增加 val
    void add(int o, int l, int r, int idx, int val) {
        if (l == r) {
            min[o] += val;
            sum[o] += val;
            return;
        }
        int m = l + ((r - l) >> 1);
        if (idx <= m) {
            add(o * 2, l, m, idx, val);
        } else {
            add(o * 2 + 1, m + 1, r, idx, val);
        }
        min[o] = Math.min(min[o * 2], min[o * 2 + 1]);
        sum[o] = sum[o * 2] + sum[o * 2 + 1];
    }

    // 返回区间 [L,R] 内的元素和
    long querySum(int o, int l, int r, int L, int R) { // L 和 R 在整个递归过程中均不变，将其大写，视作常量
        if (L <= l && r <= R) return sum[o];
        long sum = 0L;
        int m = l + ((r - l) >> 1);
        if (L <= m) {
            sum += querySum(o * 2, l, m, L, R);
        }
        if (R > m) {
            sum += querySum(o * 2 + 1, m + 1, r, L, R);
        }
        return sum;
    }

    // 返回区间 [1,R] 中 <= val 的最靠左的位置，不存在时返回 0
    // R 在整个递归过程中均不变，将其大写，视作常量
    int index(int o, int l, int r, int R, int val) {
        if (min[o] > val) {
            // 说明整个区间的元素值都大于 val
            return 0;
        }
        if (l == r) return l;
        int m = l + ((r - l) >> 1);
        if (min[o * 2] <= val) {
            // 看看左半部分
            return index(o * 2, l, m, R, val);
        }
        if (m < R) {
            // 看看右半部分
            return index(o * 2 + 1, m + 1, r, R, val);
        }
        return 0;
    }
}
