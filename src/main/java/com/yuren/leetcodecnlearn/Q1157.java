package com.yuren.leetcodecnlearn;

import java.util.ArrayList;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-21 23:41
 */
public class Q1157 {
    SegmentTree st;

    CountQuicker cq;

    public Q1157(int[] arr) {
        st = new SegmentTree(arr);
        cq = new CountQuicker(arr);
    }

    public int query(int left, int right, int threshold) {
        int query = st.query(left, right);
        int realTimes = cq.realTimes(left, right, query);
        return realTimes >= threshold ? query : -1;

    }

    class SegmentTree {
        public int[] candidate;
        public int[] hp;
        public int n;

        public SegmentTree(int[] arr) {
            int n = arr.length;
            this.n = n;
            candidate = new int[(n + 1) << 2];
            hp = new int[(n + 1) << 2];
            build(arr, 1, n, 1);
        }

        public void build(int[] arr, int l, int r, int rt) {
            if (l == r) {
                candidate[rt] = arr[l - 1];
                hp[rt] = 1;
            } else {
                int mid = (l + r) >> 1;
                build(arr, l, mid, rt << 1);
                build(arr, mid + 1, r, rt << 1 | 1);
                int lc = candidate[rt << 1];
                int rc = candidate[rt << 1 | 1];
                int lh = hp[rt << 1];
                int rh = hp[rt << 1 | 1];
                if (lc == rc) {
                    candidate[rt] = lc;
                    hp[rt] = lh + rh;
                } else {
                    candidate[rt] = lh >= rh ? lc : rc;
                    hp[rt] = Math.abs(lh - rh);
                }
            }
        }

        public int query(int left, int right) {
            return query(left + 1, right + 1, 1, n, 1)[0];
        }

        private int[] query(int L, int R, int l, int r, int rt) {
            if (L <= l && r <= R) {
                return new int[]{candidate[rt], hp[rt]};
            } else {
                int mid = (l + r) >> 1;
                if (R <= mid) {
                    return query(L, R, l, mid, rt << 1);
                } else if (L > mid) {
                    return query(L, R, mid + 1, r, rt << 1 | 1);
                } else {
                    int[] left = query(L, R, l, mid, rt << 1);
                    int[] right = query(L, R, mid + 1, r, rt << 1 | 1);
                    if (left[0] == right[0]) {
                        left[1] += right[1];
                        return left;
                    } else {
                        if (left[1] >= right[1]) {
                            left[1] -= right[1];
                            return left;
                        } else {
                            right[1] -= left[1];
                            return right;
                        }
                    }
                }
            }
        }
    }

    private static class CountQuicker {
        public ArrayList<ArrayList<Integer>> cnt;

        public CountQuicker(int[] arr) {
            cnt = new ArrayList<>();
            int max = 0;
            for (int num : arr) {
                max = Math.max(max, num);
            }
            for (int i = 0; i <= max; i++) {
                cnt.add(new ArrayList<>());
            }
            for (int i = 0; i < arr.length; i++) {
                cnt.get(arr[i]).add(i);
            }
        }


        public int realTimes(int left, int right, int num) {
            ArrayList<Integer> list = cnt.get(num);
            return size(list, right) - size(list, left - 1);
        }

        public int size(ArrayList<Integer> list, int index) {
            int l = 0;
            int r = list.size() - 1;
            int mid = 0;
            int ans = -1;
            while (l <= r) {
                mid = (l + r) >> 1;
                if (list.get(mid) <= index) {
                    l = mid + 1;
                    ans = mid;
                } else {
                    r = mid - 1;
                }
            }
            return ans + 1;
        }
    }
}
