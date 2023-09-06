package com.yuren.leetcodecnlearn.Q1900;

import java.util.BitSet;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-06 23:29
 */
public class Q1906 {


    static class Seg {
        int l, r;
        BitSet bs = new BitSet(101);

        Seg left, right;

        static Seg build(int l, int r, int[] num) {
            if (l > r) return null;

            Seg root = new Seg();
            root.l = l;
            root.r = r;
            if (l == r) {
                root.bs.set(num[l]);
                return root;
            }

            int m = l + (r - l) / 2;

            root.left = Seg.build(l, m, num);
            root.right = Seg.build(m + 1, r, num);

            root.bs.or(root.left.bs);
            root.bs.or(root.right.bs);

            return root;
        }

        static void query(Seg root, int l, int r, BitSet bs) {
            if (root.l == l && root.r == r) {
                bs.or(root.bs);
                return;
            }

            int m = root.l + (root.r - root.l) / 2;

            if (r <= m) {
                query(root.left, l, r, bs);
            } else if (l > m) {
                query(root.right, l, r, bs);
            } else {
                query(root.left, l, m, bs);
                query(root.right, m + 1, r, bs);
            }

        }

    }

    public int[] minDifference(int[] nums, int[][] queries) {

        // 1 到 100?
        int n = nums.length;
        Seg root = Seg.build(0, n - 1, nums);

        int m = queries.length;
        int[] res = new int[m];

        for (int i = 0; i < m; i++) {

            res[i] = -1;
            int[] q = queries[i];

            // 获取区间内，包含[1,100]的覆盖值
            BitSet bs = new BitSet(101);
            Seg.query(root, q[0], q[1], bs);

            // 计算最小值
            int t1 = -1;
            for (int j = 1; j <= 100; j++) {
                if (bs.get(j)) {
                    if (t1 != -1) {
                        if (res[i] == -1 || res[i] > j - t1) {
                            res[i] = j - t1;

                            // 最优解，提前退出
                            if (res[i] == 1) {
                                break;
                            }
                        }
                    }
                    t1 = j;
                }
            }
        }

        return res;
    }
}
