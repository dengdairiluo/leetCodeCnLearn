package com.yuren.leetcodecnlearn.Q2500;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-31 上午12:58
 */
public class Q2569 {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        int m = queries.length;
        SegTree tree = new SegTree(nums1);

        long sum = 0;
        for (int num : nums2) {
            sum += num;
        }
        List<Long> list = new ArrayList<>();
        for (int[] query : queries) {
            if (query[0] == 1) {
                int l = query[1];
                int r = query[2];
                tree.reverseRange(l, r);
            } else if (query[0] == 2) {
                sum += (long) tree.sumRange(0, n - 1) * query[1];
            } else if (query[0] == 3) {
                list.add(sum);
            }
        }
        long[] ans = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }


    private static class SegTree {
        private SegNode[] arr;

        public SegTree(int[] nums) {
            int n = nums.length;
            arr = new SegNode[n * 4 + 1];
            build(1, 0, n - 1, nums);
        }

        public int sumRange(int left, int right) {
            return query(1, left, right);
        }

        public void reverseRange(int left, int right) {
            modify(1, left, right);
        }

        public void build(int id, int l, int r, int[] nums) {
            arr[id] = new SegNode();
            arr[id].l = l;
            arr[id].r = r;
            arr[id].lazytag = false;
            if (l == r) {
                arr[id].sum = nums[l];
                return;
            }
            int mid = (l + r) >> 1;
            build(2 * id, l, mid, nums);
            build(2 * id + 1, mid + 1, r, nums);
            arr[id].sum = arr[2 * id].sum + arr[2 * id + 1].sum;
        }

        /* pushdown函数：下传懒标记，即将当前区间的修改情况下传到其左右孩子结点 */
        public void pushdown(int x) {
            if (arr[x].lazytag) {
                arr[2 * x].lazytag = !arr[2 * x].lazytag;
                arr[2 * x].sum = arr[2 * x].r - arr[2 * x].l + 1 - arr[2 * x].sum;
                arr[2 * x + 1].lazytag = !arr[2 * x + 1].lazytag;
                arr[2 * x + 1].sum = arr[2 * x + 1].r - arr[2 * x + 1].l + 1 - arr[2 * x + 1].sum;
                arr[x].lazytag = false;
            }
        }

        /* 区间修改 */
        public void modify(int id, int l, int r) {
            if (arr[id].l >= l && arr[id].r <= r) {
                arr[id].sum = (arr[id].r - arr[id].l + 1) - arr[id].sum;
                arr[id].lazytag = !arr[id].lazytag;
                return;
            }
            pushdown(id);
            int mid = (arr[id].l + arr[id].r) >> 1;
            if (arr[2 * id].r >= l) {
                modify(2 * id, l, r);
            }
            if (arr[2 * id + 1].l <= r) {
                modify(2 * id + 1, l, r);
            }
            arr[id].sum = arr[2 * id].sum + arr[2 * id + 1].sum;
        }

        /* 区间查询 */
        public int query(int id, int l, int r) {
            if (arr[id].l >= l && arr[id].r <= r) {
                return arr[id].sum;
            }
            if (arr[id].r < l || arr[id].l > r) {
                return 0;
            }
            pushdown(id);
            int res = 0;
            if (arr[2 * id].r >= l) {
                res += query(2 * id, l, r);
            }
            if (arr[2 * id + 1].l <= r) {
                res += query(2 * id + 1, l, r);
            }
            return res;
        }
    }

    private static class SegNode {
        public int l, r, sum;
        public boolean lazytag;

        public SegNode() {
            this.l = 0;
            this.r = 0;
            this.sum = 0;
            this.lazytag = false;
        }
    }

}
